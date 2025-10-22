package com.banksystem.banksystem.Controller;

import com.banksystem.banksystem.Entity.Admin;
import com.banksystem.banksystem.Service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired private AdminService adminService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "admin-login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {
        Optional<Admin> admin = adminService.login(username, password);
        if (admin.isPresent()) {
            model.addAttribute("admin", admin.get());
            model.addAttribute("admins", adminService.getAllAdmins());
            return "admin-dashboard";
        }
        return "admin-login";
    }


    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("admin", new Admin());
        return "admin-create";
    }

    @PostMapping("/create")
    public String createAdmin(@ModelAttribute Admin admin) {
        // You can hash password here if needed
        adminService.createAdmin(admin);
        return "redirect:/admin/login";
    }


    @GetMapping("/edit/{id}")
    public String editAdmin(@PathVariable int id, Model model) {
        Admin admin = adminService.getAdminById(id).orElseThrow();
        model.addAttribute("admin", admin);
        return "admin-edit";
    }

    @PostMapping("/update")
    public String updateAdmin(@ModelAttribute Admin admin) {
        adminService.updateAdmin(admin);
        return "redirect:/admin/login";
    }

    @PostMapping("/delete/{id}")
    public String deleteAdmin(@PathVariable int id) {
        adminService.deleteAdmin(id);
        return "redirect:/admin/login";
    }
}

