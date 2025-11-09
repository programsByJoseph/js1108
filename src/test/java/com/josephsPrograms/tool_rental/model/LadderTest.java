package com.josephsPrograms.tool_rental.model;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class LadderTest {

    @Test
    public void calculateChargeableDays_weekdaysAndWeekendsNoHolidays() {
        Ladder ladder = new Ladder("LADW", "Werner");
        int expectedChargeableDays = 6;
        assertEquals(expectedChargeableDays, ladder.calculateChargeableDays(7, "07/10/23"));
    }

    @Test
    public void calculateChargeableDays_saturdayIndependence() {
        Ladder ladder = new Ladder("LADW", "Werner");
        int expectedChargeableDays = 4;
        assertEquals(expectedChargeableDays, ladder.calculateChargeableDays(6, "07/01/26"));
    }

    @Test
    public void calculateChargeableDays_saturdayIndependence2() {
        Ladder ladder = new Ladder("LADW", "Werner");
        int expectedChargeableDays = 1;
        assertEquals(expectedChargeableDays, ladder.calculateChargeableDays(3, "07/01/26"));
    }

    @Test
    public void calculateChargeableDays_sundayIndependence() {
        Ladder ladder = new Ladder("LADW", "Werner");
        int expectedChargeableDays = 4;
        assertEquals(expectedChargeableDays, ladder.calculateChargeableDays(6, "07/01/27"));
    }

    @Test
    public void calculateChargeableDays_oneDayRentalShouldNoCharge() {
        Ladder ladder = new Ladder("LADW", "Werner");
        int expectedChargeableDays = 0;
        assertEquals(expectedChargeableDays, ladder.calculateChargeableDays(1, "07/01/27"));
    }


    // Exercise validation tests
    @Test
    public void calculateChargeableDays_exerciseValidation() {
        Ladder ladder = new Ladder("LADW", "Werner");
        int expectedChargeableDays = 1;
        assertEquals(expectedChargeableDays, ladder.calculateChargeableDays(3, "07/02/20"));
    }

    @Test
    public void calculatePreDiscountCharge_exerciseValidation() {
        Ladder ladder = new Ladder("LADW", "Werner");
        BigDecimal result = ladder.calculatePreDiscountCharge(3, "07/02/20");
        assertEquals(new BigDecimal("1.99"), result);
    }

    @Test
    public void calculateDiscountAmount_exerciseValidation() {
        Ladder ladder = new Ladder("LADW", "Werner");
        BigDecimal result = ladder.calculateDiscountAmount(3, "07/02/20", 10);
        assertEquals(new BigDecimal("0.20"), result);
    }

    @Test
    public void finalCharge_exerciseValidation() {
        Ladder ladder = new Ladder("LADW", "Werner");
        BigDecimal result = ladder.finalCharge(3, "07/02/20", 10);
        assertEquals(new BigDecimal("1.79"), result);
    }
}
