package com.banksystem.banksystem.Service;

import com.banksystem.banksystem.Entity.Transaction;
import com.banksystem.banksystem.Entity.User;
import com.banksystem.banksystem.Repository.TransactionRepository;
import com.banksystem.banksystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepo;

    @Autowired
    private UserRepository userRepo;

    @Transactional
    public void processTransaction(Transaction txn) {
        transactionRepo.save(txn);

        User user = userRepo.findByAccountId(txn.getAcc()).orElseThrow();

        BigDecimal currentBalance = user.getBalance();
        if ("debit".equalsIgnoreCase(txn.getType())) {
            user.setBalance(currentBalance.subtract(txn.getAmt()));
        } else if ("credit".equalsIgnoreCase(txn.getType())) {
            user.setBalance(currentBalance.add(txn.getAmt()));
        }

        userRepo.save(user);
    }
}

