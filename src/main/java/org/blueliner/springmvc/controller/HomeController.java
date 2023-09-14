package org.blueliner.springmvc.controller;

import lombok.RequiredArgsConstructor;
import org.blueliner.springmvc.service.ClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class HomeController {
    private final ClientService clientService;

    @GetMapping
    public String getAllDeposits(Model model) {
        model.addAttribute("deposits", clientService.getAllDeposits());
        return "index";
    }
}
