package com.josephsPrograms.tool_rental.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HolidayUtilTest {
    @Test
    public void testIsIndependenceDay_true() {
        HolidayUtil util = new HolidayUtil();
        assertTrue(util.isIndependenceDay("07/04/25")); // method always returns false in current code
    }

    @Test
    public void testIsIndependenceDay_false() {
        HolidayUtil util = new HolidayUtil();
        assertFalse(util.isIndependenceDay("07/05/25"));
    }

    @Test
    public void testIsLaborDay_true() {
        HolidayUtil util = new HolidayUtil();
        assertTrue(util.isLaborDay("09/01/25")); // method always returns false in current code
    }

    @Test
    public void testIsLaborDay_false() {
        HolidayUtil util = new HolidayUtil();
        assertFalse(util.isLaborDay("09/02/25"));
    }

    @Test
    public void testIsLaborDay_falseOnDifferentMonday() {
        HolidayUtil util = new HolidayUtil();
        assertFalse(util.isLaborDay("09/08/25"));
    }

//    @Test
//    public void testIsIndependenceDay_false_wrongMonth() {
//        HolidayUtil util = new HolidayUtil();
//        assertFalse(util.isIndependenceDay("08/04/25"));
//    }
//
//    @Test
//    public void testIsIndependenceDay_false_wrongDay() {
//        HolidayUtil util = new HolidayUtil();
//        assertFalse(util.isIndependenceDay("07/05/25"));
//    }
//
//    @Test
//    public void testIsIndependenceDay_false_wrongYear() {
//        HolidayUtil util = new HolidayUtil();
//        assertFalse(util.isIndependenceDay("07/04/24"));
//    }
//
//    @Test
//    public void testIsIndependenceDay_malformedInput() {
//        HolidayUtil util = new HolidayUtil();
//        assertFalse(util.isIndependenceDay("badinput"));
//    }
}

