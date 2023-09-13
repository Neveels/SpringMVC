package org.blueliner.springmvc.service;

import org.blueliner.springmvc.dto.DepositResponse;

import java.util.List;

/**
 * @author Neevels
 * @version 1.0
 * @date 13.09.2023 10:59
 */
public interface ClientService {
    List<DepositResponse> getAllDeposits();
}
