package org.blueliner.springmvc.repository;

import org.blueliner.springmvc.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
public interface OperationRepository extends JpaRepository<Operation, Long> {
}
