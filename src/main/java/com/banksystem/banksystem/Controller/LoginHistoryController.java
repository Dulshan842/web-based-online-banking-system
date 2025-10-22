package com.banksystem.banksystem.Controller;

import com.banksystem.banksystem.Entity.LoginHistory;
import com.banksystem.banksystem.Service.LoginHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class LoginHistoryController {

    @Autowired private LoginHistoryService loginHistoryService;

    @GetMapping("/login-history")
    public String viewLoginHistory(@RequestParam("userId") int userId, Model model) {
        List<LoginHistory> history = loginHistoryService.getHistoryByUser(userId);
        model.addAttribute("history", history);
        model.addAttribute("userId", userId);
        return "login-history";
    }

    @PostMapping("/login-history/delete/{id}")
    public String deleteLoginRecord(@PathVariable int id, @RequestParam("userId") int userId) {
        loginHistoryService.deleteRecord(id);
        return "redirect:/login-history?userId=" + userId;
    }

    // NEW ROUTE - Show edit page
    @GetMapping("/login-history/edit/{id}")
    public String editLoginRecord(@PathVariable int id, @RequestParam("userId") int userId, Model model) {
        Optional<LoginHistory> entry = loginHistoryService.getById(id);
        if (entry.isEmpty()) {
            return "redirect:/login-history?userId=" + userId;
        }
        model.addAttribute("entry", entry.get());
        model.addAttribute("userId", userId);
        return "edit-login-history";
    }

    // NEW ROUTE - Update record
    @PostMapping("/login-history/update")
    public String updateLoginRecord(@RequestParam("id") int id,
                                    @RequestParam("userId") int userId,
                                    @RequestParam("ipAddress") String ipAddress,
                                    @RequestParam(value = "note", required = false) String note) {
        Optional<LoginHistory> optEntry = loginHistoryService.getById(id);
        if (optEntry.isPresent()) {
            LoginHistory entry = optEntry.get();
            entry.setIpAddress(ipAddress);
            entry.setNote(note);
            loginHistoryService.updateRecord(entry);
        }
        return "redirect:/login-history?userId=" + userId;
    }
}