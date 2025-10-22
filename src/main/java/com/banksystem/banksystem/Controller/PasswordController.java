package com.banksystem.banksystem.Controller;

import com.banksystem.banksystem.Entity.SecurityQuestion;
import com.banksystem.banksystem.Entity.User;
import com.banksystem.banksystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class PasswordController {

    @Autowired private UserService userService;

    @GetMapping("/forgot-password")
    public String showForgotForm() {
        return "forgot-password";
    }

    @PostMapping("/forgot-password")
    public String verifySecurity(@RequestParam String accountId,
                                 @RequestParam List<String> answers,
                                 @RequestParam String newPassword,
                                 Model model) {
        Optional<User> userOpt = userService.getUserByAccountId(accountId);
        if (userOpt.isEmpty()) {
            model.addAttribute("error", "Account not found.");
            return "forgot-password";
        }

        User user = userOpt.get();
        List<SecurityQuestion> questions = userService.getSecurityQuestions(user.getId());

        boolean match = true;
        for (int i = 0; i < answers.size(); i++) {
            if (!questions.get(i).getAnswer().equals(answers.get(i))) {
                match = false;
                break;
            }
        }

        if (match) {
            user.setPassword(newPassword);
            userService.updateUser(user);
            return "redirect:/login";
        }

        model.addAttribute("error", "Answers did not match.");
        return "forgot-password";
    }
}

