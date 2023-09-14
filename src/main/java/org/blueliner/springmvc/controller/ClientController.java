package org.blueliner.springmvc.controller;

import lombok.RequiredArgsConstructor;
import org.blueliner.springmvc.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

/**
 * @author Neevels
 * @version 1.0
 * @date 13.09.2023 10:52
 */
@Controller
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;


    @PostMapping("/submit-deposit")
    public String getAllBalance(@RequestParam("depositType") String depositType,
                                @RequestParam("depositAmount") Long depositAmount,
                                Model model) {
        model.addAttribute("ownDeposits", clientService.createDeposit(depositAmount, depositType));
        return "view-deposits";
    }

    @PostMapping("/deposit-funds")
    public void updateBalance(@RequestParam("emailForUpdate") String email,
                              @RequestParam("depositAmount") Long balance) {
        clientService.updateBalance(email, balance);
    }

    @PostMapping("/withdraw-funds")
    public String updateDepositBalance(@RequestParam("type") String depositType,
                              @RequestParam("amount") Long depositAmount, Model model) {
        clientService.updateDepositBalance(depositType, depositAmount);
        return "redirect:/";
    }

    @GetMapping("/balance")
    public String getBalance(Model model) {
        model.addAttribute("balance", clientService.getBalanceOnDate());
        return "balance";
    }


    @GetMapping("/amount")
    public String getAmountOfAccruals(@RequestParam("from") LocalDate localDateFrom,
                                      @RequestParam("to") LocalDate localDateTo,
                                      Model model) {
        model.addAttribute("amount", clientService.getAmountOfAccruals(localDateFrom, localDateTo));
        return "amount";
    }
}
