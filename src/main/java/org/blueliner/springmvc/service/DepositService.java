package org.blueliner.springmvc.service;


import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.blueliner.springmvc.model.Deposit;
import org.blueliner.springmvc.repository.DepositRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Neevels
 * @version 1.0
 * @date 13.09.2023 10:53
 */
@Service
@RequiredArgsConstructor
public class DepositService {
    private final DepositRepository depositRepository;

//    @PostConstruct
    public void createSomeDeposits() {
        depositRepository.saveAll(List.of(
                Deposit.builder()
                        .name("First")
                        .minimalSumOfDeposit(100L)
                        .interestRate(3)
                        .build(),
                Deposit.builder()
                        .name("Second")
                        .minimalSumOfDeposit(200L)
                        .interestRate(7)
                        .build(),
                Deposit.builder()
                        .name("Third")
                        .minimalSumOfDeposit(300L)
                        .interestRate(1)
                        .build(),
                Deposit.builder()
                        .name("Fourth")
                        .minimalSumOfDeposit(400L)
                        .interestRate(5)
                        .build(),
                Deposit.builder()
                        .name("Fourth")
                        .minimalSumOfDeposit(500L)
                        .interestRate(4)
                        .build()

        ));
    }

}
