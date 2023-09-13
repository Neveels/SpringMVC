package org.blueliner.springmvc.repository;

import org.blueliner.springmvc.model.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Neevels
 * @version 1.0
 * @date 13.09.2023 10:54
 */
@Repository
public interface DepositRepository extends JpaRepository<Deposit, Long> {
}
