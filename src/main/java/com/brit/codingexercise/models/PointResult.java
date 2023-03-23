package com.brit.codingexercise.models;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PointResult {
    public BigInteger customerId;
    public Integer totalPoints;
    public List<PointsEarnedPerMonth> monthlyEarnedPoints;

    public PointResult(BigInteger customerId, int points) {
        this.customerId = customerId;
        this.totalPoints = points;
        monthlyEarnedPoints = new ArrayList<>();
    }
}
