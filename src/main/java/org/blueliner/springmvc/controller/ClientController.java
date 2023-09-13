package org.blueliner.springmvc.controller;

import lombok.RequiredArgsConstructor;
import org.blueliner.springmvc.dto.DepositResponse;
import org.blueliner.springmvc.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Neevels
 * @version 1.0
 * @date 13.09.2023 10:52
 */
@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    @PostMapping("")
    public

    @GetMapping
    public ResponseEntity<List<DepositResponse>> getAllDeposits() {
        return ResponseEntity.ok(clientService.getAllDeposits());
    }

}
