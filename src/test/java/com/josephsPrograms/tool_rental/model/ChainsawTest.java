package com.josephsPrograms.tool_rental.model;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class ChainsawTest {

    @Test
    public void chainsawConstructor_setsFieldsCorrectly() {
        Chainsaw chainsaw = new Chainsaw("CHNS", "Stihl");

        assertTrue(chainsaw.isCode("CHNS"));
        assertTrue(chainsaw.isBrand("Stihl"));
        assertTrue(chainsaw.isType("Chainsaw"));
        assertEquals(0, chainsaw.getDailyCharge().compareTo(BigDecimal.valueOf(1.49)));
        assertTrue(chainsaw.hasWeekdayCharge());
        assertFalse(chainsaw.hasWeekendCharge());
        assertTrue(chainsaw.hasHolidayCharge());
    }
}

