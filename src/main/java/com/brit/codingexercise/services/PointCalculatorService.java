package com.brit.codingexercise.services;

import org.springframework.stereotype.Component;

@Component
public class PointCalculatorService {

    public int calculatePointsEarnedByTransaction(double amount) {
        if(amount <= 50)
            return 0;
        if(amount <= 100) {
            return (int) (Math.floor(amount) - 50);
        }
        return (int) ((Math.floor(amount)-100)*2 + 50);
    }
}
