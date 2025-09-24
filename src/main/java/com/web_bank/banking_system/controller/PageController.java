package com.web_bank.banking_system.controller;

import com.web_bank.banking_system.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class PageController {

    @Autowired private TransactionRepository transactionRepo;

    @GetMapping("/")
    public String index() { return "index"; }

    @GetMapping("/bill")
    public String billPage() { return "bill"; }

    @GetMapping("/transaction")
    public String transactionPage() { return "transaction"; }


    @GetMapping("/success")
    public String successPage() { return "success"; }
}

