package com.brit.codingexercise.models;

import com.fasterxml.jackson.annotation.JsonGetter;

import java.time.Month;

public class PointsEarnedPerMonth {
    public int amount;
    public Month month;

    public PointsEarnedPerMonth(Month month, int amount) {
        this.month = month;
        this.amount = amount;
    }
}
