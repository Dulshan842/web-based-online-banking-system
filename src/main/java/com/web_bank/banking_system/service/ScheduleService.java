package com.web_bank.banking_system.service;

import com.web_bank.banking_system.entity.Schedule;
import com.web_bank.banking_system.repository.TransactionRepository;
import com.web_bank.banking_system.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ScheduleService {

    private final Map<Integer, Schedule> scheduledMap = new HashMap<>();
    private int nextId = 1000;

    @Autowired
    private TransactionRepository transactionRepository;

    public void scheduleTransaction(Schedule tx) {
        tx.setId(nextId++);
        scheduledMap.put(tx.getId(), tx);
    }

    public void deleteScheduledTransaction(int id) {
        scheduledMap.remove(id);
    }

    public void activateScheduledTransaction(int id) {
        Schedule tx = scheduledMap.get(id);
        if (tx != null) {
            Transaction realTx = new Transaction();
            realTx.setAcc(tx.getAcc());
            realTx.setAmt(tx.getAmt());
            realTx.setDate(tx.getDate());
            realTx.setName(tx.getName());
            realTx.setBank(tx.getBank());
            realTx.setReason(tx.getReason());
            realTx.setType(tx.getType());
            transactionRepository.save(realTx);
            scheduledMap.remove(id);
        }
    }

    public Collection<Schedule> getAllScheduled() {
        return scheduledMap.values();
    }
}

