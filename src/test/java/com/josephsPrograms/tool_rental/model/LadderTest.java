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
    public void convertsDate() {
        Ladder ladder = new Ladder("LAD1", "Werner");

        ladder.calculateCharge(1, 0, "07/02/25");
    }
}

