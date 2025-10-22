package com.banksystem.banksystem.Controller;

import com.banksystem.banksystem.Entity.Transaction;
import com.banksystem.banksystem.Repository.TransactionRepository;
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
        return "redirect:/success";
    }

    @GetMapping("/ping")
    @ResponseBody
    public String ping() {
        return "Backend is alive!";
    }
}





