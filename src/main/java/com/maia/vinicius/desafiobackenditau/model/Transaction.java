package com.maia.vinicius.desafiobackenditau.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public class Transaction {

    private BigDecimal value;
    private OffsetDateTime dateTime;

    public Transaction(final BigDecimal value, final OffsetDateTime dateTime) {
        this.value = value;
        this.dateTime = dateTime;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public OffsetDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(OffsetDateTime dateTime) {
        this.dateTime = dateTime;
    }
}