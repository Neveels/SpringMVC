package org.blueliner.springmvc.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {
    @ExceptionHandler(BusinessException.class)
    public String handleCustomException(BusinessException ex, Model model) {
        model.addAttribute("e", ex.getMessage());
        return "error";
    }
}
