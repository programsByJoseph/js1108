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

    @Test
    public void calculateChargeableDays_exerciseValidation() {
        Ladder ladder = new Ladder("LADW", "Werner");
        int expectedChargeableDays = 1;
        assertEquals(expectedChargeableDays, ladder.calculateChargeableDays(3, "07/02/20"));
    }

//    @Test
//    public void calculatePreDiscountCharge_noHolidays() {
//        Ladder ladder = new Ladder("LADW", "Werner");
//        int expectedChargeableDays = 5;
//        assertEquals(expectedChargeableDays,  ladder.calculateChargeableDays(5, "07/07/25"));
//    }
//
//    // Covers rental period with a weekday holiday (Independence Day on Friday)
//    @Test
//    public void calculatePreDiscountCharge_holidayOnWeekday() {
//        Ladder ladder = new Ladder("LADW", "Werner");
//        int expectedChargeableDays = 4;
//        assertEquals(expectedChargeableDays,  ladder.calculateChargeableDays(5, "07/01/25"));
//    }
//
//    @Test
//    public void calculatePreDiscountCharge_holidayOnSaturday() {
//        Ladder ladder = new Ladder("LADW", "Werner");
//        int expectedChargeableDays = 4;
//
//        assertEquals(expectedChargeableDays,  ladder.calculateChargeableDays(5, "07/01/20"));
//    }
//
//    @Test
//    public void calculatePreDiscountCharge_holidayOnSunday() {
//        Ladder ladder = new Ladder("LADW", "Werner");
//        int expectedChargeableDays = 4;
//
//        assertEquals(expectedChargeableDays,  ladder.calculateChargeableDays(5, "07/04/21"));
//    }
//
//    @Test
//    public void calculatePreDiscountCharge_holidayIsOnlyDay() {
//        Ladder ladder = new Ladder("LADW", "Werner");
//        int expectedChargeableDays = 0;
//        assertEquals(expectedChargeableDays,  ladder.calculateChargeableDays(1, "07/04/21"));
//    }
//
//    @Test
//    public void calculatePreDiscountCharge_laborDay() {
//        Ladder ladder = new Ladder("LADW", "Werner");
//        int expectedChargeableDays = 6;
//
//        assertEquals(expectedChargeableDays,  ladder.calculateChargeableDays(7, "08/31/25"));
//    }
//
//    @Test
//    public void calculateCharge_calculatePreDiscountLaborDayOnlyDay() {
//        Ladder ladder = new Ladder("LADW", "Werner");
//        int expectedChargeableDays = 0;
//
//        assertEquals(expectedChargeableDays,  ladder.calculateChargeableDays(1, "09/01/25"));
//    }
//
//    @Test
//    void calculateDiscountAmount_calculatesDiscountAmountCorrectly() {
//        Ladder ladder = new Ladder("LADW", "Werner");
//        BigDecimal preDiscountCharge = new BigDecimal(100);
//        BigDecimal expectedDiscountAmount = new BigDecimal(20.00).setScale(2);
//        assertEquals(expectedDiscountAmount, ladder.calculateDiscountAmount(preDiscountCharge, 20));
//    }
//
//    @Test
//    void calculateDiscountAmount_calculates0DiscountCorrectly() {
//        Ladder ladder = new Ladder("LADW", "Werner");
//        BigDecimal preDiscountCharge = new BigDecimal(100);
//        BigDecimal expectedDiscountAmount = new BigDecimal(0).setScale(2);
//        assertEquals(expectedDiscountAmount, ladder.calculateDiscountAmount(preDiscountCharge, 0));
//    }
//
//    @Test
//    void calculateDiscountAmount_calculates100DiscountCorrectly() {
//        Ladder ladder = new Ladder("LADW", "Werner");
//        BigDecimal preDiscountCharge = new BigDecimal(100);
//        BigDecimal expectedDiscountAmount = new BigDecimal(100).setScale(2);
//        assertEquals(expectedDiscountAmount, ladder.calculateDiscountAmount(preDiscountCharge, 100));
//    }
//
//    @Test
//    void finalCharge() {
//        Ladder ladder = new Ladder("LADW", "Werner");
//        BigDecimal preDiscountCharge = new BigDecimal(100);
//        BigDecimal expectedDiscountAmount = new BigDecimal(100).setScale(2);
//        assertEquals(expectedDiscountAmount, ladder.calculateDiscountAmount(preDiscountCharge, 100));
//    }
}
