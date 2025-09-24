package com.web_bank.banking_system.controller;

import com.web_bank.banking_system.entity.Bill;
import com.web_bank.banking_system.entity.Transaction;
import com.web_bank.banking_system.repository.BillRepository;
import com.web_bank.banking_system.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BankController {

    @Autowired private TransactionRepository transactionRepo;
    @Autowired private BillRepository billRepo;

    @PostMapping("/transaction")
    public ResponseEntity<String> saveTransaction(@RequestBody Transaction tx) {
        transactionRepo.save(tx);
        return ResponseEntity.ok("Transaction saved");
    }

    @PostMapping("/bill")
    public ResponseEntity<String> saveBill(@RequestBody Bill bill) {
        billRepo.save(bill);
        return ResponseEntity.ok("Bill saved");
    }

    @DeleteMapping("/scheduled")
    public ResponseEntity<String> deleteScheduled(@RequestParam String acc, @RequestParam String date) {
        LocalDate d = LocalDate.parse(date);
        List<Transaction> scheduled = transactionRepo.findByAccAndDateAndType(acc, d, "scheduled");
        transactionRepo.deleteAll(scheduled);
        return ResponseEntity.ok("Scheduled transaction deleted");
    }
}

