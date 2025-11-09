package com.josephsPrograms.tool_rental.model;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class LadderTest {

    @Test
    public void calculatePreDiscountCharge_noHolidays() {
        Ladder ladder = new Ladder("LADW", "Werner");
        int expectedChargeableDays = 5;
        assertEquals(expectedChargeableDays,  ladder.calculateChargeableDays(5, "07/07/25"));
    }

    @Test
    public void calculatePreDiscountCharge_holidayOnWeekday() {
        Ladder ladder = new Ladder("LADW", "Werner");
        int expectedChargeableDays = 4;
        assertEquals(expectedChargeableDays,  ladder.calculateChargeableDays(5, "07/01/25"));
    }

    @Test
    public void calculatePreDiscountCharge_holidayOnSaturday() {
        Ladder ladder = new Ladder("LADW", "Werner");
        int expectedChargeableDays = 4;

        assertEquals(expectedChargeableDays,  ladder.calculateChargeableDays(5, "07/01/20"));
    }

    @Test
    public void calculatePreDiscountCharge_holidayOnSunday() {
        Ladder ladder = new Ladder("LADW", "Werner");
        int expectedChargeableDays = 4;

        assertEquals(expectedChargeableDays,  ladder.calculateChargeableDays(5, "07/04/21"));
    }

    @Test
    public void calculatePreDiscountCharge_holidayIsOnlyDay() {
        Ladder ladder = new Ladder("LADW", "Werner");
        int expectedChargeableDays = 0;
        assertEquals(expectedChargeableDays,  ladder.calculateChargeableDays(1, "07/04/21"));
    }

    @Test
    public void calculatePreDiscountCharge_laborDay() {
        Ladder ladder = new Ladder("LADW", "Werner");
        int expectedChargeableDays = 6;

        assertEquals(expectedChargeableDays,  ladder.calculateChargeableDays(7, "08/31/25"));
    }

    @Test
    public void calculateCharge_calculatePreDiscountLaborDayOnlyDay() {
        Ladder ladder = new Ladder("LADW", "Werner");
        int expectedChargeableDays = 0;

        assertEquals(expectedChargeableDays,  ladder.calculateChargeableDays(1, "09/01/25"));
    }

    @Test
    void dueDateCalculatesCorrectly() {
        Ladder ladder = new Ladder("LADW", "Werner");
        assertEquals("07/06/25", ladder.getDueDate(3, "07/04/25"));
    }

    @Test
    void dueDateCalculatesMonthChangeCorrectly() {
        Ladder ladder = new Ladder("LADW", "Werner");
        assertEquals("08/01/25", ladder.getDueDate(3, "07/30/25"));
    }

    @Test
    void calculateDiscountAmount_calculatesDiscountAmountCorrectly() {
        Ladder ladder = new Ladder("LADW", "Werner");
        BigDecimal preDiscountCharge = new BigDecimal(100);
        BigDecimal expectedDiscountAmount = new BigDecimal(20.00).setScale(2);
        assertEquals(expectedDiscountAmount, ladder.calculateDiscountAmount(preDiscountCharge, 20));
    }

    @Test
    void calculateDiscountAmount_calculates0DiscountCorrectly() {
        Ladder ladder = new Ladder("LADW", "Werner");
        BigDecimal preDiscountCharge = new BigDecimal(100);
        BigDecimal expectedDiscountAmount = new BigDecimal(0).setScale(2);
        assertEquals(expectedDiscountAmount, ladder.calculateDiscountAmount(preDiscountCharge, 0));
    }

    @Test
    void calculateDiscountAmount_calculates100DiscountCorrectly() {
        Ladder ladder = new Ladder("LADW", "Werner");
        BigDecimal preDiscountCharge = new BigDecimal(100);
        BigDecimal expectedDiscountAmount = new BigDecimal(100).setScale(2);
        assertEquals(expectedDiscountAmount, ladder.calculateDiscountAmount(preDiscountCharge, 100));
    }

    @Test
    void finalCharge() {
        Ladder ladder = new Ladder("LADW", "Werner");
        BigDecimal preDiscountCharge = new BigDecimal(100);
        BigDecimal expectedDiscountAmount = new BigDecimal(100).setScale(2);
        assertEquals(expectedDiscountAmount, ladder.calculateDiscountAmount(preDiscountCharge, 100));
    }
}

