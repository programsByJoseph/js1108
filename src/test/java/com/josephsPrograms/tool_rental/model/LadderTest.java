package com.josephsPrograms.tool_rental.model;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class LadderTest {

    @Test
    public void ladderConstructor_setsFieldsCorrectly() {
        Ladder ladder = new Ladder("LAD1", "Werner");

        assertTrue(ladder.isCode("LAD1"));
        assertTrue(ladder.isBrand("Werner"));
        assertTrue(ladder.isType("Ladder"));
        assertEquals(0, ladder.getDailyCharge().compareTo(BigDecimal.valueOf(1.99)));
        assertTrue(ladder.hasWeekdayCharge());
        assertTrue(ladder.hasWeekendCharge());
        assertFalse(ladder.hasHolidayCharge());
    }

    @Test
    public void calculateCharge_noHolidays() {
        Ladder ladder = new Ladder("LADW", "Werner");
        int expectedChargeableDays = 5;
        assertEquals(expectedChargeableDays,  ladder.calculateChargeableDays(5, "07/07/25"));
    }

    @Test
    public void calculateCharge_holidayOnWeekday() {
        Ladder ladder = new Ladder("LADW", "Werner");
        int expectedChargeableDays = 4;
        assertEquals(expectedChargeableDays,  ladder.calculateChargeableDays(5, "07/01/25"));
    }

    @Test
    public void calculateCharge_holidayOnSaturday() {
        Ladder ladder = new Ladder("LADW", "Werner");
        int expectedChargeableDays = 4;
        assertEquals(expectedChargeableDays,  ladder.calculateChargeableDays(5, "07/01/20"));
    }

    @Test
    public void calculateCharge_holidayOnSunday() {
        Ladder ladder = new Ladder("LADW", "Werner");
        int expectedChargeableDays = 4;
        assertEquals(expectedChargeableDays,  ladder.calculateChargeableDays(5, "07/04/21"));
    }
}

