package com.brit.codingexercise.models;

import java.math.BigInteger;

public class Transaction {

    public Transaction(BigInteger customerId, double amount) {
        this.customerId = customerId;
        this.amount = amount;
    }
    public BigInteger customerId;
    public double amount;
}
