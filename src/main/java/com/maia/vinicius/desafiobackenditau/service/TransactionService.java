package com.maia.vinicius.desafiobackenditau.service;

import com.maia.vinicius.desafiobackenditau.exceptions.InvalidTransactionException;
import com.maia.vinicius.desafiobackenditau.model.Transaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    private final List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction transaction) {
        if (transaction.getValue().compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidTransactionException("Transaction value must be greater than zero.");
        }

        OffsetDateTime now = OffsetDateTime.now(ZoneOffset.UTC);

        if(transaction.getDateTime().isAfter(now)) {
            throw new InvalidTransactionException("Transaction date time cannot be in the future.");
        }
        transactions.add(transaction);
    }
}
