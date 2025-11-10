package com.josephsPrograms.tool_rental.model;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class ChainsawTest {

    @Test
    public void calculateChargeableDays_noHoliday() {
        Chainsaw chainsaw = new Chainsaw("CHNS", "Stihl");
        int expectedChargeableDays = 4;
        assertEquals(expectedChargeableDays,  chainsaw.calculateChargeableDays(5, "11/10/25"));
    }

    @Test
    public void calculateChargeableDays_weekdayHolidayLaborDay() {
        Chainsaw chainsaw = new Chainsaw("CHNS", "Stihl");
        int expectedChargeableDays = 4;
        assertEquals(expectedChargeableDays,  chainsaw.calculateChargeableDays(5, "09/01/25"));
    }

    @Test
    public void calculateChargeableDays_weekdayHolidayJuly() {
        Chainsaw chainsaw = new Chainsaw("CHNS", "Stihl");
        int expectedChargeableDays = 3;
        assertEquals(expectedChargeableDays,  chainsaw.calculateChargeableDays(5, "07/01/25"));
    }

    @Test
    public void calculateChargeableDays_oneDayRental() {
        Chainsaw chainsaw = new Chainsaw("CHNS", "Stihl");
        int expectedChargeableDays = 1;
        assertEquals(expectedChargeableDays,  chainsaw.calculateChargeableDays(1, "07/01/25"));
    }

    // EXCEPTION HANDLING TESTS
    @Test
    void calculatePreDiscountCharge_throwsExceptionForInvalidRentalDays() {
        Chainsaw chainsaw = new Chainsaw("CHNS", "Stihl");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            chainsaw.calculatePreDiscountCharge(0, "07/01/27");
        });
        String expectedMessage = "Rental day count must be at least 1. Provided count: 0";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void calculateDiscountAmount_throwsExceptionForInvalidRentalDays() {
        Chainsaw chainsaw = new Chainsaw("CHNS", "Stihl");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            chainsaw.calculateDiscountAmount(0, "07/01/27", 10);
        });
        String expectedMessage = "Rental day count must be at least 1. Provided count: 0";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void calculateDiscountAmount_throwsExceptionForInvalidDiscountAmountNegative() {
        Chainsaw chainsaw = new Chainsaw("CHNS", "Stihl");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            chainsaw.calculateDiscountAmount(1, "07/01/27", -1);
        });
        String expectedMessage = "Discount percentage must be between 0 and 100. Provided percentage: -1";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void calculateDiscountAmount_throwsExceptionForInvalidDiscountAmountOver100() {
        Chainsaw chainsaw = new Chainsaw("CHNS", "Stihl");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            chainsaw.calculateDiscountAmount(1, "07/01/27", 101);
        });
        String expectedMessage = "Discount percentage must be between 0 and 100. Provided percentage: 101";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void finalCharge_throwsExceptionForInvalidRentalDays() {
        Chainsaw chainsaw = new Chainsaw("CHNS", "Stihl");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            chainsaw.finalCharge(0, "07/01/27", 10);
        });
        String expectedMessage = "Rental day count must be at least 1. Provided count: 0";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void finalCharge_throwsExceptionForInvalidDiscountAmountNegative() {
        Chainsaw chainsaw = new Chainsaw("CHNS", "Stihl");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            chainsaw.finalCharge(1, "07/01/27", -1);
        });
        String expectedMessage = "Discount percentage must be between 0 and 100. Provided percentage: -1";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void finalCharge_throwsExceptionForInvalidDiscountAmountOver100() {
        Chainsaw chainsaw = new Chainsaw("CHNS", "Stihl");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            chainsaw.finalCharge(1, "07/01/27", 101);
        });
        String expectedMessage = "Discount percentage must be between 0 and 100. Provided percentage: 101";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void calculateChargeableDays_invalidRentalDays() {
        Chainsaw chainsaw = new Chainsaw("CHNS", "Stihl");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            chainsaw.calculateChargeableDays(0, "07/01/27");
        });
        String expectedMessage = "Rental day count must be at least 1. Provided count: 0";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    //Exercise validation tests
    @Test
    public void calculateChargeableDays_exerciseValidation() {
        Chainsaw chainsaw = new Chainsaw("CHNS", "Stihl");
        int expectedChargeableDays = 3;
        assertEquals(expectedChargeableDays,  chainsaw.calculateChargeableDays(5, "07/02/15"));
    }

    @Test
    public void calculatePreDiscountCharge_exerciseValidation() {
        Chainsaw chainsaw = new Chainsaw("CHNS", "Stihl");
        BigDecimal preDiscountCharge = chainsaw.calculatePreDiscountCharge(5, "07/02/15");
        assertEquals(new BigDecimal("4.47"),  preDiscountCharge);
    }

    @Test
    public void calculateDiscountAmount_exerciseValidation() {
        Chainsaw chainsaw = new Chainsaw("CHNS", "Stihl");
        BigDecimal discountAmount = chainsaw.calculateDiscountAmount(5, "07/02/15", 25);
        assertEquals(new BigDecimal("1.12"),  discountAmount);
    }

    @Test
    public void finalCharge_exerciseValidation() {
        Chainsaw chainsaw = new Chainsaw("CHNS", "Stihl");
        BigDecimal finalCharge = chainsaw.finalCharge(5, "07/02/15", 25);
        assertEquals(new BigDecimal("3.35"),  finalCharge);
    }
}

