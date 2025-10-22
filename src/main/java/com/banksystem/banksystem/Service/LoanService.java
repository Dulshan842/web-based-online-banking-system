package com.banksystem.banksystem.Service;

import com.banksystem.banksystem.Entity.Loan;
import com.banksystem.banksystem.Repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    @Autowired private LoanRepository loanRepo;

    public void createLoan(Loan loan) {
        loan.setMaxLimit(new java.math.BigDecimal("30000")); // enforce max limit
        loanRepo.save(loan);
    }

    public List<Loan> getLoansByUser(int userId) {
        return loanRepo.findByUserId(userId);
    }

    public void updateLoan(Loan loan) {
        loan.setMaxLimit(new java.math.BigDecimal("30000")); // enforce max limit
        loanRepo.save(loan);
    }

    public void deleteLoan(int id) {
        loanRepo.deleteById(id);
    }

    public Loan getLoanById(int id) {
        return loanRepo.findById(id).orElseThrow();
    }
}
