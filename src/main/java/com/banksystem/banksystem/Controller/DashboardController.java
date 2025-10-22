package com.banksystem.banksystem.Controller;

import com.banksystem.banksystem.Entity.User;
import com.banksystem.banksystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class DashboardController {

    @Autowired private UserService userService;

    @GetMapping("/dashboard")
    public String dashboard(@RequestParam("userId") int userId, Model model) {
        User user = userService.getUserById(userId).orElseThrow();
        model.addAttribute("user", user);
        return "dashboard";
    }
    @GetMapping("/index")
    public String transactionPage() {
        return "index"; // Loads index.html from templates
    }
    @GetMapping("/index-loan")
    public String LoanPage() {
        return "index-loan";
    }



}
