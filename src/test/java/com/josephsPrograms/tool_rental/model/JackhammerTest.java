package com.josephsPrograms.tool_rental.model;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class JackhammerTest {

    @Test
    public void calculateChargeableDays_weekdaysOnlyNoHolidays() {
        Jackhammer jack = new Jackhammer("JAKR", "Ridgid");
        int chargeable = jack.calculateChargeableDays(5, "07/07/25");
        assertEquals(4, chargeable);
    }

    @Test
    public void calculateChargeableDays_includesIndependenceDay() {
        Jackhammer jack = new Jackhammer("JAKR", "Ridgid");
        int chargeable = jack.calculateChargeableDays(4, "07/01/25");
        assertEquals(2, chargeable);
    }

    @Test
    public void calculateChargeableDays_includesLaborDay() {
        Jackhammer jack = new Jackhammer("JAKR", "Ridgid");
        int chargeable = jack.calculateChargeableDays(5, "09/01/25");
        assertEquals(3, chargeable);
    }

    @Test
    public void calculateChargeableDays_july4FridayLogic() {
        Jackhammer jack = new Jackhammer("JAKR", "Ridgid");
        int chargeable = jack.calculateChargeableDays(4, "07/01/26");
        assertEquals(1, chargeable);
    }

    @Test
    public void calculateChargeableDays_july4MondayLogic() {
        Jackhammer jack = new Jackhammer("JAKR", "Bosch");
        int chargeable = jack.calculateChargeableDays(5, "07/01/27");
        assertEquals(1, chargeable);
    }

    @Test
    public void calculateChargeableDays_july4OnSaturdayRentalIncludesSaturday() {
        Jackhammer jack = new Jackhammer("JAKR", "Bosch");
        int chargeable = jack.calculateChargeableDays(6, "07/01/27");
        assertEquals(2, chargeable);
    }

    @Test
    public void calculateChargeableDays_july4OnSundayRentalIncludesSunday() {
        Jackhammer jack = new Jackhammer("JAKR", "Bosch");
        int chargeable = jack.calculateChargeableDays(5, "07/01/27");
        assertEquals(1, chargeable);
    }

    @Test
    public void calculateChargeableDays_oneDayRentalShouldNoCharge() {
        Jackhammer jack = new Jackhammer("JAKR", "Bosch");
        int chargeable = jack.calculateChargeableDays(1, "07/01/27");
        assertEquals(0, chargeable);
    }


    // EXERCISE VALIDATION TESTS

    @Test
    public void calculateChargeableDays_exerciseValidationTest1() {
        Jackhammer jack = new Jackhammer("JAKR", "Bosch");
        int chargeable = jack.calculateChargeableDays(5, "09/03/15");
        assertEquals(1, chargeable);
    }

    @Test
    public void calculatePreDiscountCharge_correctlyCalculatesTest1() {
        Jackhammer jack = new Jackhammer("JAKR", "Bosch");
        BigDecimal preDiscountCharge = jack.calculatePreDiscountCharge(5, "09/03/15");
        assertEquals(new BigDecimal("2.99"), preDiscountCharge);
    }


    @Test
    public void calculateChargeableDays_exerciseValidationTest4() {
        Jackhammer jack = new Jackhammer("JAKD", "Bosch");
        int chargeable = jack.calculateChargeableDays(6, "09/03/15");
        assertEquals(2, chargeable);
    }

    @Test
    public void calculatePreDiscountCharge_exerciseValidationTest4() {
        Jackhammer jack = new Jackhammer("JAKD", "Bosch");
        BigDecimal preDiscountCharge = jack.calculatePreDiscountCharge(6, "09/03/15");
        assertEquals(new BigDecimal("5.98"), preDiscountCharge);
    }

    @Test
    public void calculateDiscountAmount_correctlyCalculatesTest4() {
        Jackhammer jack = new Jackhammer("JAKD", "Bosch");
        BigDecimal discountAmount = jack.calculateDiscountAmount(6, "09/03/15", 0);
        assertEquals(new BigDecimal("0.00"), discountAmount);
    }

    @Test
    public void calculateFinalCharge_correctlyCalculatesTest4() {
        //BigDecimal finalCharge(int rentalDayCount, String checkoutDate, int discountPercentage)
        Jackhammer jack = new Jackhammer("JAKR", "Bosch");
        BigDecimal finalCharge = jack.finalCharge(5, "09/03/15", 0);
        assertEquals(new BigDecimal("2.99"), finalCharge);
    }


    @Test
    public void calculateChargeableDays_exerciseValidationTest5() {
        Jackhammer jack = new Jackhammer("JAKR", "Bosch");
        int chargeable = jack.calculateChargeableDays(9, "07/02/15");
        assertEquals(5, chargeable);
    }

    @Test
    public void calculatePreDiscountCharge_exerciseValidationTest5() {
        Jackhammer jack = new Jackhammer("JAKR", "Bosch");
        BigDecimal preDiscountCharge = jack.calculatePreDiscountCharge(9, "07/02/15");
        assertEquals(new BigDecimal("14.95"), preDiscountCharge);
    }

    @Test
    public void calculateDiscountAmount_exerciseValidationTest5() {
        Jackhammer jack = new Jackhammer("JAKR", "Bosch");
        BigDecimal discountAmount = jack.calculateDiscountAmount(9, "07/02/15", 0);
        assertEquals(new BigDecimal("0.00"), discountAmount);
    }

    @Test
    public void calculateFinalCharge_correctlyCalculatesTest5() {
        Jackhammer jack = new Jackhammer("JAKR", "Bosch");
        BigDecimal finalCharge = jack.finalCharge(9, "07/02/15", 0);
        assertEquals(new BigDecimal("14.95"), finalCharge);
    }


    @Test
    public void calculateChargeableDays_exerciseValidationTest6() {
        Jackhammer jack = new Jackhammer("JAKR", "Bosch");
        int chargeable = jack.calculateChargeableDays(4, "07/02/20");
        assertEquals(0, chargeable);
    }

    @Test
    public void calculatePreDiscountCharge_exerciseValidationTest6() {
        Jackhammer jack = new Jackhammer("JAKR", "Bosch");
        BigDecimal preDiscountCharge = jack.calculatePreDiscountCharge(4, "07/02/20");
        assertEquals(new BigDecimal("0.00"), preDiscountCharge);
    }

    @Test
    public void calculateDiscountAmount_exerciseValidationTest6() {
        Jackhammer jack = new Jackhammer("JAKR", "Bosch");
        BigDecimal discountAmount = jack.calculateDiscountAmount(4, "07/02/20", 50);
        assertEquals(new BigDecimal("0.00"), discountAmount);
    }

    @Test
    public void calculateFinalCharge_correctlyCalculatesTest6() {
        Jackhammer jack = new Jackhammer("JAKR", "Bosch");
        BigDecimal finalCharge = jack.finalCharge(4, "07/02/20", 50);
        assertEquals(new BigDecimal("0.00"), finalCharge);
    }
}
