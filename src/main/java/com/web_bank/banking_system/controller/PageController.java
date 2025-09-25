package com.web_bank.banking_system.controller;

import com.web_bank.banking_system.service.ScheduledTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @Autowired
    private ScheduledTransactionService scheduledService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/bill")
    public String billPage() {
        return "bill";
    }

    @GetMapping("/transaction")
    public String transactionPage() {
        return "transaction";
    }

    @GetMapping("/success")
    public String successPage() {
        return "success";
    }

    @GetMapping("/schedule")
    public String viewScheduled(Model model) {
        model.addAttribute("scheduledList", scheduledService.getAllScheduled());
        return "schedule";
    }
}




