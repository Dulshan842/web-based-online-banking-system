package com.banksystem.banksystem.Service;

import com.banksystem.banksystem.Entity.LoginHistory;
import com.banksystem.banksystem.Repository.LoginHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginHistoryService {

    @Autowired private LoginHistoryRepository loginRepo;

    public List<LoginHistory> getHistoryByUser(int userId) {
        return loginRepo.findByUserId(userId);
    }

    public void deleteRecord(int id) {
        loginRepo.deleteById(id);
    }

    // NEW METHOD
    public Optional<LoginHistory> getById(int id) {
        return loginRepo.findById(id);
    }

    // NEW METHOD
    public void updateRecord(LoginHistory entry) {
        loginRepo.save(entry);
    }
}