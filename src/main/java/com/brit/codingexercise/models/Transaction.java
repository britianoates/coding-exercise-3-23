package com.brit.codingexercise.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Date;

public class Transaction {

    public Transaction(BigInteger customerId, double amount, LocalDate date) {
        this.customerId = customerId;
        this.amount = amount;
        this.date = date;
    }
    public BigInteger customerId;
    public double amount;
    @JsonFormat(pattern = "yyyy-mm-dd")
    public LocalDate date;
}
