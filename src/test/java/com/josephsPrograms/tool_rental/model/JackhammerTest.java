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

    @Test
    public void calculateChargeableDays_exerciseValidationTest1() {
        Jackhammer jack = new Jackhammer("JAKR", "Bosch");
        int chargeable = jack.calculateChargeableDays(5, "09/03/15");
        assertEquals(1, chargeable);
    }

    @Test
    public void calculateChargeableDays_exerciseValidationTest4() {
        Jackhammer jack = new Jackhammer("JAKD", "Bosch");
        int chargeable = jack.calculateChargeableDays(6, "09/03/15");
        assertEquals(2, chargeable);
    }

    @Test
    public void calculateChargeableDays_exerciseValidationTest5() {
        Jackhammer jack = new Jackhammer("JAKD", "Bosch");
        int chargeable = jack.calculateChargeableDays(9, "07/02/15");
        assertEquals(5, chargeable);
    }
}
