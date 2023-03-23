package com.brit.codingexercise.controllers;
import com.brit.codingexercise.models.PointResult;
import com.brit.codingexercise.models.Transaction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;

@RestController
public class PointCalculatorController {

    @PostMapping("/calculate-points")
    public ArrayList<PointResult> calculatePoints(@RequestBody()ArrayList<Transaction> transactions) {
        return new ArrayList<>();
    }
}
