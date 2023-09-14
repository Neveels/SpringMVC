package org.blueliner.springmvc.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class DepositResponse {
    Long id;
    String name;
    Integer interestRate;
    Long minimalSumOfDeposit;
}
