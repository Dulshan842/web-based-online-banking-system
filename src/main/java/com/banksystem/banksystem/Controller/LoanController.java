package com.banksystem.banksystem.Controller;

import com.banksystem.banksystem.Entity.Loan;
import com.banksystem.banksystem.Service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/loan")
public class LoanController {

    @Autowired private LoanService loanService;

    @GetMapping("/index-loan")
    public String indexLoanPage() {
        return "index-loan";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("loan", new Loan());
        return "loan";
    }

    @PostMapping("/create")
    public String createLoan(@ModelAttribute Loan loan) {
        loanService.createLoan(loan);
        return "redirect:/loan/updated?userId=" + loan.getUserId();
    }

    @GetMapping("/updated")
    public String viewUpdatedLoans(@RequestParam("userId") int userId, Model model) {
        model.addAttribute("loans", loanService.getLoansByUser(userId));
        return "updated-loans";
    }

    @GetMapping("/edit/{id}")
    public String editLoan(@PathVariable int id, Model model) {
        model.addAttribute("loan", loanService.getLoanById(id));
        return "upload-loan-details";
    }

    @PostMapping("/update")
    public String updateLoan(@ModelAttribute Loan loan) {
        loanService.updateLoan(loan);
        return "redirect:/loan/updated?userId=" + loan.getUserId();
    }

    @PostMapping("/delete/{id}")
    public String deleteLoan(@PathVariable int id, @RequestParam int userId) {
        loanService.deleteLoan(id);
        return "redirect:/loan/updated?userId=" + userId;
    }
}
