package com.web_bank.banking_system.controller;

import com.web_bank.banking_system.entity.Bill;
import com.web_bank.banking_system.entity.Transaction;
import com.web_bank.banking_system.entity.ScheduledTransaction;
import com.web_bank.banking_system.repository.BillRepository;
import com.web_bank.banking_system.repository.TransactionRepository;
import com.web_bank.banking_system.service.ScheduledTransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class BankController {

    @Autowired
    private TransactionRepository transactionRepo;

    @Autowired
    private BillRepository billRepo;

    @Autowired
    private ScheduledTransactionService scheduledService;

    @GetMapping("/scheduled")
    public String showScheduleForm(Model model) {
        model.addAttribute("scheduleTx", new ScheduledTransaction());
        return "scheduled";
    }

    @PostMapping("/schedule")
    public String submitSchedule(@ModelAttribute ScheduledTransaction tx) {
        scheduledService.save(tx);
        return "redirect:/schedule";
    }

    @PostMapping("/cancelSchedule")
    public String cancelSchedule(@RequestParam int id) {
        scheduledService.deleteScheduled(id);
        return "redirect:/schedule";
    }

    @PostMapping("/confirmSchedule")
    public String confirmSchedule(@RequestParam int id) {
        boolean success = scheduledService.confirmScheduled(id);
        return success ? "redirect:/schedule" : "redirect:/schedule?error=true";
    }

    @GetMapping("/editScheduled/{id}")
    public String editScheduled(@PathVariable int id, Model model) {
        ScheduledTransaction tx = scheduledService.getById(id).orElseThrow();
        model.addAttribute("scheduleTx", tx); // ✅ Must match th:object
        return "edit-scheduled";
    }


    @PostMapping("/updateSchedule")
    public String updateSchedule(@ModelAttribute ScheduledTransaction tx) {
        scheduledService.save(tx);
        return "redirect:/schedule";
    }


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
}
