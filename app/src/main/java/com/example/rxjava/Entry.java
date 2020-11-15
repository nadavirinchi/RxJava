package com.example.rxjava;

import java.math.BigDecimal;
import java.util.Date;

public class Entry {
    private  final String EntryName;
    private final BigDecimal EntryPrice;
    private final Date EntryDate;

    public Entry(String entryName, BigDecimal entryPrice, Date entryDate) {
        EntryName = entryName;
        EntryPrice = entryPrice;
        EntryDate = entryDate;
    }

    public String getEntryName() {
        return EntryName;
    }

    public BigDecimal getEntryPrice() {
        return EntryPrice;
    }

    public Date getEntryDate() {
        return EntryDate;
    }
}
