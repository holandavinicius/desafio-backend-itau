package com.maia.vinicius.desafiobackenditau.controller;

import com.maia.vinicius.desafiobackenditau.dto.TransactionRequest;
import com.maia.vinicius.desafiobackenditau.exceptions.InvalidTransactionException;
import com.maia.vinicius.desafiobackenditau.model.Transaction;
import com.maia.vinicius.desafiobackenditau.service.TransactionService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {

    private final TransactionService transactionService;

    private static final Logger log = LoggerFactory.getLogger(TransactionController.class);

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transaction")
    public ResponseEntity<?> createTransaction(@Valid @RequestBody TransactionRequest request){
        log.info("POST /transaction | New value received: {} | Timestamp: {}", request.getValue(), request.getDateTime());

        Transaction transaction = new Transaction(request.getValue(), request.getDateTime());
        try {
            transactionService.addTransaction(transaction);

            log.info("New transaction created. value: {} | Timestamp: {}", request.getValue(), request.getDateTime());
            return ResponseEntity.status(HttpStatus.CREATED).build(); // 201 Created, sem corpo
        } catch (InvalidTransactionException e) {
            log.info("Error creating transaction: {}", e.getMessage());
            return ResponseEntity.unprocessableEntity().build(); // 422 Unprocessable Entity
        }
    }

    @DeleteMapping("/transaction")
    public ResponseEntity<?> deleteTransactions(){
        log.info("DELETE request received from /transaction");

        transactionService.deleteTransactions();

        log.info("Transactions deleted");
        return ResponseEntity.ok().build();
    }
}
