package org.blueliner.springmvc.dto;

import lombok.Builder;

/**
 * @author Neevels
 * @version 1.0
 * @date 13.09.2023 10:59
 */
@Builder
public record DepositResponse(
        Long id,
        String name,
        Integer interestRate,
        Long minimalSumOfDeposit
) {
}
