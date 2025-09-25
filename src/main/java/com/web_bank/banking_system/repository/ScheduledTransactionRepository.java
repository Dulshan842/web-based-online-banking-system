package com.web_bank.banking_system.repository;

import com.web_bank.banking_system.entity.ScheduledTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduledTransactionRepository extends JpaRepository<ScheduledTransaction, Integer> {
}
