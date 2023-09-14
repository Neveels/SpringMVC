package org.blueliner.springmvc.service;

import org.blueliner.springmvc.dto.OwnDepositsResponse;
import org.blueliner.springmvc.model.Deposit;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Neevels
 * @version 1.0
 * @date 13.09.2023 10:59
 */
public interface ClientService {
    List<Deposit> getAllDeposits();
    Long getBalanceOnDate();
    Long calculateInterest(Long accountId, int months);

    void updateBalance(String email, Long balance);

    List<OwnDepositsResponse> createDeposit(Long depositAmount, String depositType);

    List<OwnDepositsResponse> getAllActiveDeposits();

    Double getAmountOfAccruals(LocalDate localDateFrom, LocalDate localDateTo);

    void updateDepositBalance(String depositType, Long depositAmount);
}
