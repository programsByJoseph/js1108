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

    //Exception handling tests
    @Test
    void calculatePreDiscountCharge_throwsExceptionForInvalidRentalDays() {
        Ladder ladder = new Ladder("LADW", "Werner");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ladder.calculatePreDiscountCharge(0, "07/01/27");
        });
        String expectedMessage = "Rental day count must be at least 1. Provided count: 0";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void calculateDiscountAmount_throwsExceptionForInvalidRentalDays() {
        Ladder ladder = new Ladder("LADW", "Werner");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ladder.calculateDiscountAmount(0, "07/01/27", 10);
        });
        String expectedMessage = "Rental day count must be at least 1. Provided count: 0";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void calculateDiscountAmount_throwsExceptionForInvalidDiscountAmountNegative() {
        Ladder ladder = new Ladder("LADW", "Werner");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ladder.calculateDiscountAmount(1, "07/01/27", -1);
        });
        String expectedMessage = "Discount percentage must be between 0 and 100. Provided percentage: -1";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void calculateDiscountAmount_throwsExceptionForInvalidDiscountAmountOver100() {
        Ladder ladder = new Ladder("LADW", "Werner");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ladder.calculateDiscountAmount(1, "07/01/27", 101);
        });
        String expectedMessage = "Discount percentage must be between 0 and 100. Provided percentage: 101";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void finalCharge_throwsExceptionForInvalidRentalDays() {
        Ladder ladder = new Ladder("LADW", "Werner");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ladder.finalCharge(0, "07/01/27", 10);
        });
        String expectedMessage = "Rental day count must be at least 1. Provided count: 0";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void finalCharge_throwsExceptionForInvalidDiscountAmountNegative() {
        Ladder ladder = new Ladder("LADW", "Werner");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ladder.finalCharge(1, "07/01/27", -1);
        });
        String expectedMessage = "Discount percentage must be between 0 and 100. Provided percentage: -1";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void finalCharge_throwsExceptionForInvalidDiscountAmountOver100() {
        Ladder ladder = new Ladder("LADW", "Werner");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ladder.finalCharge(1, "07/01/27", 101);
        });
        String expectedMessage = "Discount percentage must be between 0 and 100. Provided percentage: 101";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void calculateChargeableDays_invalidRentalDays() {
        Ladder ladder = new Ladder("LADW", "Werner");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ladder.calculateChargeableDays(0, "07/01/27");
        });
        String expectedMessage = "Rental day count must be at least 1. Provided count: 0";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
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
