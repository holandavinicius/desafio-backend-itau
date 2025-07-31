package com.maia.vinicius.desafiobackenditau.controller;

import com.maia.vinicius.desafiobackenditau.dto.TransactionRequest;
import com.maia.vinicius.desafiobackenditau.exceptions.InvalidTransactionException;
import com.maia.vinicius.desafiobackenditau.model.Transaction;
import com.maia.vinicius.desafiobackenditau.service.TransactionService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transaction")
    public ResponseEntity<?> createTransaction(@Valid @RequestBody TransactionRequest request){
        Transaction transaction = new Transaction(request.getValue(), request.getDateTime());
        try {
            transactionService.addTransaction(transaction);
            return ResponseEntity.status(HttpStatus.CREATED).build(); // 201 Created, sem corpo
        } catch (InvalidTransactionException e) {
            return ResponseEntity.unprocessableEntity().build(); // 422 Unprocessable Entity
        }
    }
}
