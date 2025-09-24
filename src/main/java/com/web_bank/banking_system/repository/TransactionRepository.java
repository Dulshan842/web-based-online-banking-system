package com.web_bank.banking_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.web_bank.banking_system.entity.Transaction;
import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findByDateAfter(LocalDate date);
    List<Transaction> findByAccAndDateAndType(String acc, LocalDate date, String type);
}
