package com.banksystem.banksystem.Repository;

import com.banksystem.banksystem.Entity.ScheduledTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScheduledTransactionRepository extends JpaRepository<ScheduledTransaction, Integer> {
}
