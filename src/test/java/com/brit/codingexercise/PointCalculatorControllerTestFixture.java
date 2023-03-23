package com.brit.codingexercise;

import static org.assertj.core.api.Assertions.assertThat;

import com.brit.codingexercise.controllers.PointCalculatorController;
import com.brit.codingexercise.models.PointResult;
import com.brit.codingexercise.models.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class PointCalculatorControllerTestFixture {

    @Autowired
    private PointCalculatorController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void returnsCustomersFromInput() {
        List<PointResult> result = controller.calculatePoints(Arrays.asList(new Transaction(BigInteger.valueOf(1), 4.10, LocalDate.of(2023, 3, 23))));
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).customerId).isEqualTo(BigInteger.valueOf(1));
    }

    @Test
    public void returnsCustomersWithPointsFromFirstRule() {
        List<PointResult> result = controller.calculatePoints(Arrays.asList(new Transaction(BigInteger.valueOf(1), 59.12, LocalDate.of(2023, 3, 23))));
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).customerId).isEqualTo(BigInteger.valueOf(1));
        assertThat(result.get(0).totalPoints).isEqualTo(9);
    }

    @Test
    public void returnsCustomersWithPointsFromFirstAndSecondRules() {
        List<PointResult> result = controller.calculatePoints(Arrays.asList(new Transaction(BigInteger.valueOf(1), 120.0, LocalDate.of(2023, 3, 23))));
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).customerId).isEqualTo(BigInteger.valueOf(1));
        assertThat(result.get(0).totalPoints).isEqualTo(90);
    }
    @Test
    public void returnsCustomersWithPointsTotaledFromMultipleTransactions() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction(BigInteger.valueOf(1), 120.0, LocalDate.of(2023, 3, 23)),
                new Transaction(BigInteger.valueOf(1), 110.99, LocalDate.of(2023, 3, 23))
                );
        List<PointResult> result = controller.calculatePoints(transactions);
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).customerId).isEqualTo(BigInteger.valueOf(1));
        assertThat(result.get(0).totalPoints).isEqualTo(160);
    }
    @Test
    public void returnsMultipleCustomersInOrderOfCustomerId() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction(BigInteger.valueOf(2), 120.0, LocalDate.of(2023, 3, 23)),
                new Transaction(BigInteger.valueOf(1), 150.00, LocalDate.of(2023, 3, 23))
        );
        List<PointResult> result = controller.calculatePoints(transactions);
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).customerId).isEqualTo(BigInteger.valueOf(1));
        assertThat(result.get(1).customerId).isEqualTo(BigInteger.valueOf(2));
    }

    @Test
    public void returnsMultipleCustomersWithPointsTotaledFromMultipleTransactions() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction(BigInteger.valueOf(1), 120.0, LocalDate.of(2023, 3, 23)),
                new Transaction(BigInteger.valueOf(1), 110.99, LocalDate.of(2023, 3, 23)),
                new Transaction(BigInteger.valueOf(2), 150.00, LocalDate.of(2023, 3, 23)),
                new Transaction(BigInteger.valueOf(2), 17.99, LocalDate.of(2023, 3, 23)),
                new Transaction(BigInteger.valueOf(5), 75.99, LocalDate.of(2023, 3, 23)),
                new Transaction(BigInteger.valueOf(1), 101.00, LocalDate.of(2023, 3, 23)),
                new Transaction(BigInteger.valueOf(4), 15.99, LocalDate.of(2023, 3, 23)),
                new Transaction(BigInteger.valueOf(3), 50.99, LocalDate.of(2023, 3, 23)),
                new Transaction(BigInteger.valueOf(2), 150.00, LocalDate.of(2023, 3, 23))
        );
        List<PointResult> result = controller.calculatePoints(transactions);
        assertThat(result.size()).isEqualTo(5);
        assertThat(result.get(0).customerId).isEqualTo(BigInteger.valueOf(1));
        assertThat(result.get(0).totalPoints).isEqualTo(212);
        assertThat(result.get(1).customerId).isEqualTo(BigInteger.valueOf(2));
        assertThat(result.get(1).totalPoints).isEqualTo(300);
        assertThat(result.get(2).customerId).isEqualTo(BigInteger.valueOf(3));
        assertThat(result.get(2).totalPoints).isEqualTo(0);
        assertThat(result.get(3).customerId).isEqualTo(BigInteger.valueOf(4));
        assertThat(result.get(3).totalPoints).isEqualTo(0);
        assertThat(result.get(4).customerId).isEqualTo(BigInteger.valueOf(5));
        assertThat(result.get(4).totalPoints).isEqualTo(25);
    }
    @Test
    public void returnsMonthlyPoints() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction(BigInteger.valueOf(1), 120.0, LocalDate.of(2023, 3, 23)),
                new Transaction(BigInteger.valueOf(1), 120.0, LocalDate.of(2023, 3, 23))
        );
        List<PointResult> result = controller.calculatePoints(transactions);
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).customerId).isEqualTo(BigInteger.valueOf(1));
        assertThat(result.get(0).monthlyEarnedPoints.size()).isEqualTo(1);
        assertThat(result.get(0).monthlyEarnedPoints.get(0).month.name()).isEqualTo("MARCH");
        assertThat(result.get(0).monthlyEarnedPoints.get(0).amount).isEqualTo(180);
    }
    @Test
    public void returnsMultipleMonthlyPoints() {
        List<Transaction> transactions = Arrays.asList(
                new Transaction(BigInteger.valueOf(1), 120.00, LocalDate.of(2023, 3, 23)),
                new Transaction(BigInteger.valueOf(1), 110.00, LocalDate.of(2023, 2, 23))
        );
        List<PointResult> result = controller.calculatePoints(transactions);
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).customerId).isEqualTo(BigInteger.valueOf(1));
        assertThat(result.get(0).monthlyEarnedPoints.size()).isEqualTo(2);
        assertThat(result.get(0).monthlyEarnedPoints.get(0).month.name()).isEqualTo("FEBRUARY");
        assertThat(result.get(0).monthlyEarnedPoints.get(0).amount).isEqualTo(70);
        assertThat(result.get(0).monthlyEarnedPoints.get(1).month.name()).isEqualTo("MARCH");
        assertThat(result.get(0).monthlyEarnedPoints.get(1).amount).isEqualTo(90);
    }
}
