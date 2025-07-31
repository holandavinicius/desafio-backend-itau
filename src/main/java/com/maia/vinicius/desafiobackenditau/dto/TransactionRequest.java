package com.maia.vinicius.desafiobackenditau.dto;

import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class TransactionRequest {

    @NotNull
    private BigDecimal value;

    @NotNull
    private OffsetDateTime dateTime;

    public TransactionRequest(){}

    public TransactionRequest(BigDecimal value, OffsetDateTime dateTime) {
        this.value = value;
        this.dateTime = dateTime;
    }

    public @NotNull BigDecimal getValue() {
        return value;
    }

    public void setValue(@NotNull BigDecimal value) {
        this.value = value;
    }

    public @NotNull OffsetDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(@NotNull OffsetDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
