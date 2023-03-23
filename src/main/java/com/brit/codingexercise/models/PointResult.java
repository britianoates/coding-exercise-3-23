package com.brit.codingexercise.models;

import java.math.BigInteger;

public class PointResult {
    public BigInteger customerId;
    public Integer points;

    public PointResult(BigInteger customerId, int points) {
        this.customerId = customerId;
        this.points = points;
    }
}
