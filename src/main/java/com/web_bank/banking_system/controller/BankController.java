package com.web_bank.banking_system.controller;

import com.web_bank.banking_system.entity.Bill;
import com.web_bank.banking_system.entity.Schedule;
import com.web_bank.banking_system.entity.Transaction;
import com.web_bank.banking_system.repository.BillRepository;
import com.web_bank.banking_system.service.ScheduleService;
import com.web_bank.banking_system.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/api")
public class BankController {

    @Autowired
    private TransactionRepository transactionRepo;
    @Autowired
    private BillRepository billRepo;
    @Autowired
    private ScheduleService scheduleService;


    @PostMapping("/bill")
    public String saveBill(@ModelAttribute Bill bill) {
        billRepo.save(bill);
        return "redirect:/success";
    }

    @PostMapping("/transaction")
    public String saveTransaction(@ModelAttribute Transaction tx) {
        transactionRepo.save(tx);
        return "redirect:/success";

    }

    @GetMapping("/scheduled")
    public String showScheduleForm(Model model) {
        model.addAttribute("scheduleTx", new Schedule());
        return "scheduled";
    }



}