package com.brit.codingexercise.controllers;
import com.brit.codingexercise.models.PointResult;
import com.brit.codingexercise.models.Transaction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class PointCalculatorController {

    @PostMapping("/calculate-points")
    public List<PointResult> calculatePoints(@RequestBody() List<Transaction> transactions) {
        return transactions.stream().map(transaction -> new PointResult(transaction.customerId, 0)).toList();
    }
}
