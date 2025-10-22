package com.banksystem.banksystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.banksystem.banksystem.Entity.Transaction;
import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findByDateAfter(LocalDate date);
    List<Transaction> findByAccAndDateAndType(String acc, LocalDate date, String type);
}
