package com.brit.codingexercise.controllers;

import com.brit.codingexercise.models.PointResult;
import com.brit.codingexercise.models.PointsEarnedPerMonth;
import com.brit.codingexercise.models.Transaction;
import com.brit.codingexercise.services.PointCalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
public class PointCalculatorController {

    @Autowired
    PointCalculatorService pointCalculatorService;

    @PostMapping("/calculate-points")
    public List<PointResult> calculatePoints(@RequestBody() List<Transaction> transactions) {
        List<PointResult> results = new ArrayList<>();

        transactions.forEach(transaction -> {
            PointResult pointResult = results.stream().filter(pr -> pr.customerId == transaction.customerId).findFirst().orElse(new PointResult(transaction.customerId, 0));
            if(!results.contains(pointResult))
                results.add(pointResult);
            int pointsEarnedByTransaction = pointCalculatorService.calculatePointsEarnedByTransaction(transaction.amount);
            PointsEarnedPerMonth pointsEarnedPerMonth = pointResult.monthlyEarnedPoints.stream().filter(pepm -> pepm.month == transaction.date.getMonth()).findFirst().orElse(new PointsEarnedPerMonth(transaction.date.getMonth(), 0));
            if(!pointResult.monthlyEarnedPoints.contains(pointsEarnedPerMonth))
                pointResult.monthlyEarnedPoints.add(pointsEarnedPerMonth);
            pointsEarnedPerMonth.amount += pointsEarnedByTransaction;
            pointResult.totalPoints += pointsEarnedByTransaction;
        });
        results.sort(Comparator.comparing(pointResult -> pointResult.customerId));
        results.forEach(pointResult -> pointResult.monthlyEarnedPoints.sort(Comparator.comparing(pointsEarnedPerMonth -> pointsEarnedPerMonth.month.getValue())));
        return results;
    }
}
