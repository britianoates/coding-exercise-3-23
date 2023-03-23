package com.brit.codingexercise;

import static org.assertj.core.api.Assertions.assertThat;

import com.brit.codingexercise.controllers.PointCalculatorController;
import com.brit.codingexercise.models.PointResult;
import com.brit.codingexercise.models.Transaction;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigInteger;
import java.util.Arrays;
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
        List<PointResult> result = controller.calculatePoints(Arrays.asList(new Transaction(BigInteger.valueOf(1), 4.10)));
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).customerId).isEqualTo(BigInteger.valueOf(1));
    }

    @Test
    public void returnsCustomersWithPointsFromFirstRule() {
        List<PointResult> result = controller.calculatePoints(Arrays.asList(new Transaction(BigInteger.valueOf(1), 59.12)));
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).customerId).isEqualTo(BigInteger.valueOf(1));
        assertThat(result.get(0).points).isEqualTo(9);
    }

    @Test
    public void returnsCustomersWithPointsFromFirstAndSecondRules() {
        List<PointResult> result = controller.calculatePoints(Arrays.asList(new Transaction(BigInteger.valueOf(1), 120.0)));
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).customerId).isEqualTo(BigInteger.valueOf(1));
        assertThat(result.get(0).points).isEqualTo(90);
    }
}
