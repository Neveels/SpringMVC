package org.blueliner.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/jsp-var")
public class JSPVariableController {
    @GetMapping("/by-el")
    public String byEl() {
        return "/jsp-var/by-el";
    }
}
