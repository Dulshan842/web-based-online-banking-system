package com.web_bank.banking_system.service;

import com.web_bank.banking_system.entity.ScheduledTransaction;
import com.web_bank.banking_system.repository.ScheduledTransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduledTransactionService {

    @Autowired
    private ScheduledTransactionRepository repository;

    public ScheduledTransaction save(ScheduledTransaction tx) {
        return repository.save(tx);
    }

    public List<ScheduledTransaction> getAllScheduled() {
        return repository.findAll();
    }

    public Optional<ScheduledTransaction> getById(int id) {
        return repository.findById(id);
    }


    public boolean deleteScheduled(int id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean confirmScheduled(int id) {
        Optional<ScheduledTransaction> optionalTx = repository.findById(id);
        if (optionalTx.isPresent()) {
            ScheduledTransaction tx = optionalTx.get();
            tx.setConfirmed(true);
            repository.save(tx);
            return true;
        }
        return false;
    }
}
