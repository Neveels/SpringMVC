package org.blueliner.springmvc.service.impl;

import lombok.RequiredArgsConstructor;
import org.blueliner.springmvc.dto.DepositResponse;
import org.blueliner.springmvc.repository.ClientRepository;
import org.blueliner.springmvc.repository.DepositRepository;
import org.blueliner.springmvc.service.ClientService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
    private final ModelMapper modelMapper;

    private final DepositRepository depositRepository;

    @Override
    public List<DepositResponse> getAllDeposits() {
        return depositRepository.findAll()
                .stream()
                .map(deposit -> modelMapper.map(deposit, DepositResponse.class))
                .toList();
    }
}
