package com.usbank.cashflow.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Transaction {
    private int id;
    private String description;
    private double amount;
    private String userId;
}
