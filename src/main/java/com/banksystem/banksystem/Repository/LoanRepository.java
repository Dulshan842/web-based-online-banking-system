package com.banksystem.banksystem.Repository;

import com.banksystem.banksystem.Entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
    List<Loan> findByUserId(int userId);
}


