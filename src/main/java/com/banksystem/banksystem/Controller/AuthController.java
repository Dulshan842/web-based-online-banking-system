package com.banksystem.banksystem.Controller;

import com.banksystem.banksystem.Entity.SecurityQuestion;
import com.banksystem.banksystem.Entity.User;
import com.banksystem.banksystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class AuthController {

    @Autowired private UserService userService;

    @GetMapping("/register")
    public String showRegisterForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user,
                           @RequestParam List<String> questions,
                           @RequestParam List<String> answers) {
        List<SecurityQuestion> questionList = new ArrayList<>();
        for (int i = 0; i < questions.size(); i++) {
            SecurityQuestion q = new SecurityQuestion();
            q.setQuestion(questions.get(i));
            q.setAnswer(answers.get(i));
            questionList.add(q);
        }
        userService.register(user, questionList);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String accountId,
                        @RequestParam String password,
                        Model model) {
        Optional<User> user = userService.login(accountId, password);
        if (user.isPresent()) {
            model.addAttribute("user", user.get());
            return "dashboard";
        }
        return "login";
    }
}


