package com.web_bank.banking_system.controller;

import com.web_bank.banking_system.entity.Schedule;
import com.web_bank.banking_system.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;



    @PostMapping("/scheduled")
    public String submitSchedule(@ModelAttribute Schedule scheduleTx, Model model) {
        scheduleService.scheduleTransaction(scheduleTx);
        model.addAttribute("scheduledTx", scheduleTx);
        return "scheduled";
    }

    @PostMapping("/cancelSchedule")
    public String cancelSchedule(@RequestParam int id) {
        scheduleService.deleteScheduledTransaction(id);
        return "redirect:/scheduled";
    }

    @PostMapping("/confirmSchedule")
    public String confirmSchedule(@RequestParam int id) {
        scheduleService.activateScheduledTransaction(id);
        return "redirect:/transactions";
    }

    @GetMapping("/scheduled/json")
    @ResponseBody
    public List<Schedule> getScheduledTransactions() {
        return new ArrayList<>(scheduleService.getAllScheduled());
    }
}
