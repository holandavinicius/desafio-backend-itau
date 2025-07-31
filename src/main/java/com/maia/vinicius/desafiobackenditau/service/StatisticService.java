package com.maia.vinicius.desafiobackenditau.service;

import com.maia.vinicius.desafiobackenditau.model.Transaction;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;

@Service
public class StatisticService {

    private final TransactionService transactionService;

    public StatisticService(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    public DoubleSummaryStatistics getLastStatistics(){
        OffsetDateTime now = OffsetDateTime.now();
        OffsetDateTime sixHundredSecondsAgo = now.minusSeconds(600);

        return transactionService.getAllTransactions().stream()
                .filter(tx -> isWithinLast60Seconds(tx.getDateTime(), sixHundredSecondsAgo, now))
                .map(Transaction::getValue)
                .mapToDouble(BigDecimal::doubleValue)
                .summaryStatistics();
    }

    private boolean isWithinLast60Seconds(OffsetDateTime timestamp, OffsetDateTime start, OffsetDateTime end) {
        return (timestamp.isAfter(start) || timestamp.isEqual(start))
                && (timestamp.isBefore(end) || timestamp.isEqual(end));
    }

}
