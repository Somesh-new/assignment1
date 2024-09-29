package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.service.AccountService;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/create")
    public String createAccount(@RequestParam String accountNo, @RequestParam String name, @RequestParam double amount, Model model) {
        try {
            accountService.createAccount(accountNo, name, amount);
            model.addAttribute("message", "Account created successfully");
        } catch (IllegalArgumentException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "index";
    }

    @PostMapping("/deposit")
    public String deposit(@RequestParam String accountNo, @RequestParam double amount, @RequestParam(required = false) String panCardNumber, Model model) {
        String result = accountService.deposit(accountNo, amount, panCardNumber);
        model.addAttribute("message", result);
        return "index";
    }

    @PostMapping("/withdraw")
    public String withdraw(@RequestParam String accountNo, @RequestParam double amount, Model model) {
        String result = accountService.withdraw(accountNo, amount);
        model.addAttribute("message", result);
        return "index";
    }

    @GetMapping("/balance")
    public String checkBalance(@RequestParam String accountNo, Model model) {
        try {
            double balance = accountService.checkBalance(accountNo);
            model.addAttribute("balance", balance);
        } catch (IllegalArgumentException e) {
            model.addAttribute("message", e.getMessage());
        }
        return "balance";
    }
}