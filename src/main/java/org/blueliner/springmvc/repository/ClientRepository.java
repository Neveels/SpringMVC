package org.blueliner.springmvc.repository;

import org.blueliner.springmvc.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author Neevels
 * @version 1.0
 * @date 13.09.2023 10:58
 */
@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByEmail(String email);
}
