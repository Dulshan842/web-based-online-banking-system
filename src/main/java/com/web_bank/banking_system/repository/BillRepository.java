package com.web_bank.banking_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.web_bank.banking_system.entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer> {
}
