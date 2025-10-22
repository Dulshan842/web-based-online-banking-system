package com.banksystem.banksystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.banksystem.banksystem.Entity.Bill;

public interface BillRepository extends JpaRepository<Bill, Integer> {
}
