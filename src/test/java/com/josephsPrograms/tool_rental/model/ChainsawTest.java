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
    public void calculateChargeableDays_oneDayRentalShouldNoCharge() {
        Chainsaw chainsaw = new Chainsaw("CHNS", "Stihl");
        int expectedChargeableDays = 0;
        assertEquals(expectedChargeableDays,  chainsaw.calculateChargeableDays(1, "07/01/25"));
    }

    //Exercise validation tests
    @Test
    public void calculateChargeableDays_exerciseValidation() {
        Chainsaw chainsaw = new Chainsaw("CHNS", "Stihl");
        int expectedChargeableDays = 2;
        assertEquals(expectedChargeableDays,  chainsaw.calculateChargeableDays(5, "07/02/15"));
    }

    @Test
    public void calculatePreDiscountCharge_exerciseValidation() {
        Chainsaw chainsaw = new Chainsaw("CHNS", "Stihl");
        BigDecimal preDiscountCharge = chainsaw.calculatePreDiscountCharge(5, "07/02/15");
        assertEquals(new BigDecimal("2.98"),  preDiscountCharge);
    }

    @Test
    public void calculateDiscountAmount_exerciseValidation() {
        Chainsaw chainsaw = new Chainsaw("CHNS", "Stihl");
        BigDecimal discountAmount = chainsaw.calculateDiscountAmount(5, "07/02/15", 25);
        assertEquals(new BigDecimal("0.75"),  discountAmount);
    }

    @Test
    public void finalCharge_exerciseValidation() {
        Chainsaw chainsaw = new Chainsaw("CHNS", "Stihl");
        BigDecimal finalCharge = chainsaw.finalCharge(5, "07/02/15", 25);
        assertEquals(new BigDecimal("2.23"),  finalCharge);
    }
}

