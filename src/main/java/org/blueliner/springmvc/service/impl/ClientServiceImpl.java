package org.blueliner.springmvc.service.impl;

import lombok.RequiredArgsConstructor;
import org.blueliner.springmvc.dto.OwnDepositsResponse;
import org.blueliner.springmvc.exception.BusinessException;
import org.blueliner.springmvc.model.Client;
import org.blueliner.springmvc.model.Deposit;
import org.blueliner.springmvc.model.Operation;
import org.blueliner.springmvc.repository.ClientRepository;
import org.blueliner.springmvc.repository.DepositRepository;
import org.blueliner.springmvc.repository.OperationRepository;
import org.blueliner.springmvc.service.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Neevels
 * @version 1.0
 * @date 13.09.2023 11:00
 */
@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final OperationRepository operationRepository;

    private final DepositRepository depositRepository;

    @Override
    public List<Deposit> getAllDeposits() {
        return depositRepository.findAll();
    }

    @Override
    public Long getBalanceOnDate() {
        return operationRepository.findAll()
            .stream()
            .mapToLong(Operation::getSumOfOperation)
            .sum();
    }

    @Override
    public Long calculateInterest(Long accountId, int months) {
        return null;
    }

    @Override
    public void updateBalance(String email, Long balance) {
        Client client = findClient(email);
        client.setBalance(client.getBalance() + balance);
        clientRepository.save(client);
    }

    @Override
    public List<OwnDepositsResponse> createDeposit(Long depositAmount, String depositType) {
        Deposit deposit = depositRepository.findById((long) Integer.parseInt(depositType)).get();
        if (deposit.getMinimalSumOfDeposit() > depositAmount) {
            throw new BusinessException("Сумма депозита должна превышать минимальную стоимость депозита!");
        }
        Operation operation = operationRepository.findAll()
            .stream()
            .filter(operation1 -> operation1.getClient().getId() == 1)
            .findFirst()
            .get();
        operation.setSumOfOperation(operation.getSumOfOperation() + depositAmount);
        operationRepository.save(operation);
        return getAllActiveDeposits();
    }

    @Override
    public List<OwnDepositsResponse> getAllActiveDeposits() {
        return operationRepository.findAll()
            .stream()
            .map(operation -> OwnDepositsResponse.builder()
                .percent(Long.valueOf(operation.getDeposit().getInterestRate()))
                .depositName(operation.getDeposit().getName())
                .sum(operation.getSumOfOperation())
                .dateOfOpening(operation.getDateOfCreation())
                .build())
            .toList();
    }

    @Override
    public Double getAmountOfAccruals(LocalDate localDateFrom, LocalDate localDateTo) {
        final int days = localDateFrom.until(localDateTo).getDays();
        return operationRepository.findAll().stream().mapToDouble(operation -> {
            Long sumOfOperation = operation.getSumOfOperation();
            Double percent = operation.getDeposit().getInterestRate() / 100.;
            int days1 = days;
            return sumOfOperation * percent * days1 / 365.;
        }).sum();
    }

    @Override
    public void updateDepositBalance(String depositType, Long depositAmount) {
        Operation operation1 = operationRepository.findAll()
            .stream()
            .filter(operation -> operation.getDeposit().getName().equals(depositType))
            .findFirst()
            .get();
        operation1.setSumOfOperation(operation1.getSumOfOperation() - depositAmount);
        operationRepository.save(operation1);
    }


    private Client findClient(String email) {
        return clientRepository.findByEmail(email).orElse(null);
    }
}
