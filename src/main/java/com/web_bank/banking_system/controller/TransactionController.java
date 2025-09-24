package com.web_bank.banking_system.controller;

import com.web_bank.banking_system.entity.Transaction;
import com.web_bank.banking_system.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    @PostMapping("/createTransaction")
    public String createTransaction(@ModelAttribute Transaction tx) {
        transactionRepository.save(tx);
        return "redirect:/transactions";
    }

    @GetMapping("/ping")
    @ResponseBody
    public String ping() {
        return "Backend is alive!";
    }
}





