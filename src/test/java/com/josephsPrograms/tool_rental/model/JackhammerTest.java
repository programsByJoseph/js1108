package com.josephsPrograms.tool_rental.model;

import org.junit.jupiter.api.Test;
import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class JackhammerTest {

    @Test
    public void jackhammerConstructor_setsFieldsCorrectly() {
        Jackhammer jack = new Jackhammer("JAK1", "Bosch");

        assertTrue(jack.isCode("JAK1"));
        assertTrue(jack.isBrand("Bosch"));
        assertTrue(jack.isType("Jackhammer"));
        assertEquals(0, jack.getDailyCharge().compareTo(BigDecimal.valueOf(2.99)));
        assertTrue(jack.hasWeekdayCharge());
        assertFalse(jack.hasWeekendCharge());
        assertFalse(jack.hasHolidayCharge());
    }
}

