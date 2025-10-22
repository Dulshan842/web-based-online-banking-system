package com.banksystem.banksystem.Repository;

import com.banksystem.banksystem.Entity.LoginHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LoginHistoryRepository extends JpaRepository<LoginHistory, Integer> {
    List<LoginHistory> findByUserId(int userId);
}
