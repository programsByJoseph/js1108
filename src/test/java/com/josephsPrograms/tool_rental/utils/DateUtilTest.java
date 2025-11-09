package com.josephsPrograms.tool_rental.utils;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilTest {
    private final DateUtil dateUtil = new DateUtil();

    @Test
    void dayIsWeekday_true() {
        Date date = new Date("11/06/25");
        assertTrue(this.dateUtil.dayIsWeekday(date));
    }

    @Test
    void dayIsWeekday_false() {
        Date date = new Date("11/08/25");
        assertFalse(this.dateUtil.dayIsWeekday(date));
    }

    @Test
    void isIndependenceDay_true() {
        Date date = new Date("07/04/25");
        assertTrue(this.dateUtil.isIndependenceDay(date));
    }

    @Test
    void isIndependenceDay_false() {
        Date date = new Date("07/05/25");
        assertFalse(this.dateUtil.isIndependenceDay(date));
    }

    @Test
    void isLaborDay_true() throws Exception {
        Date date = new Date("09/01/2025");
        assertTrue(this.dateUtil.isLaborDay(date));
    }

    @Test
    void isLaborDay_false() throws Exception {
        Date date = new Date("09/08/2025");
        assertFalse(this.dateUtil.isLaborDay(date));
    }

    @Test
    void isFridayNextDayIndependenceDay_true() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        Date friday = sdf.parse("07/03/26");
        assertTrue(dateUtil.isFridayNextDayIndependenceDay(friday));
    }

    @Test
    void isFridayNextDayIndependenceDay_false() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        Date friday = sdf.parse("07/04/25");
        assertFalse(dateUtil.isFridayNextDayIndependenceDay(friday));
    }

    @Test
    void isMondayPreviousDayIndependenceDay_true() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        Date monday = sdf.parse("07/05/21"); // July 5, 2021 is a Monday, previous day is July 4
        assertTrue(dateUtil.isMondayPreviousDayIndependenceDay(monday));
    }

    @Test
    void isMondayPreviousDayIndependenceDay_false() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        Date tuesday = sdf.parse("07/06/21"); // July 6, 2021 is a Tuesday, previous day is July 5
        assertFalse(dateUtil.isMondayPreviousDayIndependenceDay(tuesday));
    }
}