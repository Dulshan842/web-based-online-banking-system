package com.banksystem.banksystem.Service;

import com.banksystem.banksystem.Entity.*;
import com.banksystem.banksystem.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepo;
    private final SecurityQuestionRepository questionRepo;
    private final LoginHistoryRepository historyRepo;

    @Autowired
    public UserService(UserRepository userRepo,
                       SecurityQuestionRepository questionRepo,
                       LoginHistoryRepository historyRepo) {
        this.userRepo = userRepo;
        this.questionRepo = questionRepo;
        this.historyRepo = historyRepo;
    }

    public User register(User user, List<SecurityQuestion> questions) {
        userRepo.save(user);
        for (SecurityQuestion q : questions) {
            q.setUserId(user.getId());
            questionRepo.save(q);
        }
        return user;
    }

    public Optional<User> login(String accountId, String password) {
        Optional<User> user = userRepo.findByAccountId(accountId);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            LoginHistory history = new LoginHistory();
            history.setUserId(user.get().getId());
            history.setIpAddress("127.0.0.1");
            historyRepo.save(history);
            return user;
        }
        return Optional.empty();
    }

    public Optional<User> getUserByAccountId(String accountId) {
        return userRepo.findByAccountId(accountId);
    }

    @Transactional
    public void deleteUser(int userId) {
        questionRepo.deleteByUserId(userId); // Delete child glyphs first
        userRepo.deleteById(userId);         // Then delete the parent scroll
    }

    public Optional<User> getUserById(int id) {
        return userRepo.findById(id);
    }

    public List<SecurityQuestion> getSecurityQuestions(int userId) {
        return questionRepo.findByUserId(userId);
    }

    public void updateUser(User user) {
        userRepo.save(user);
    }
}
