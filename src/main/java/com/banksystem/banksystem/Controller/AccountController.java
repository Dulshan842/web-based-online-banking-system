package com.banksystem.banksystem.Controller;


import com.banksystem.banksystem.Entity.SecurityQuestion;
import com.banksystem.banksystem.Entity.SecurityQuestionForm;
import com.banksystem.banksystem.Entity.User;
import com.banksystem.banksystem.Repository.SecurityQuestionRepository;
import com.banksystem.banksystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@Controller
public class AccountController {

    @Autowired private UserService userService;
    @Autowired private SecurityQuestionRepository questionRepo;

    @GetMapping("/account/edit")
    public String showEditForm(@RequestParam("userId") int userId, Model model) {
        User user = userService.getUserById(userId).orElseThrow();
        List<SecurityQuestion> questions = questionRepo.findByUserId(userId);
        model.addAttribute("user", user);
        model.addAttribute("questions", questions);
        return "account";
    }

    @PostMapping("/account/edit")
    public String updateAccount(@ModelAttribute User user,
                                @RequestParam(required = false) String deleteField,
                                @ModelAttribute("questions") SecurityQuestionForm form,
                                Model model) {

        User existing = userService.getUserById(user.getId()).orElseThrow();

        if ("phone".equals(deleteField)) {
            existing.setPhone(null);
        } else if ("birthday".equals(deleteField)) {
            existing.setBirthday(null);
        } else if ("address".equals(deleteField)) {
            existing.setAddress(null);
        } else {
            existing.setPhone(user.getPhone());
            existing.setBirthday(user.getBirthday());
            existing.setAddress(user.getAddress());
        }

        userService.updateUser(existing);

        for (SecurityQuestion q : form.getQuestions()) {
            q.setUserId(user.getId());
            questionRepo.save(q);
        }

        model.addAttribute("user", existing);
        return "dashboard";
    }





    @PostMapping("/account/delete")
    public String deleteAccount(@RequestParam int userId) {
        userService.deleteUser(userId);
        return "redirect:/register";
    }
}

