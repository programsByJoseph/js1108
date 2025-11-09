package com.josephsPrograms.tool_rental.utils;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DateUtilTest {
    private final DateUtil dateUtil = new DateUtil();

    @Test
    void isIndependenceDayTrue() {
//        assertTrue(this.dateUtil.isIndependenceDay("07/04/25"));
    }

    @Test
    void isIndependenceDayFalse() {
//        assertFalse(this.dateUtil.isIndependenceDay("07/05/25"));
    }

//    @Test
//    void dueDateCalculatesCorrectly() {
//        String dueDate = this.dateUtil.getDueDate(3, "07/04/25");
//        assertEquals("07/06/25", dueDate);
//    }
//
//    @Test
//    void dueDateCalculatesMonthChangeCorrectly() {
//        String dueDate = this.dateUtil.getDueDate(3, "07/30/25");
//        assertEquals("08/01/25", dueDate);
//    }

    @Test
    void nextDaySaturdayTrue() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        Date friday = sdf.parse("07/03/20"); // July 3, 2020 is a Friday, next day is Saturday
        assertTrue(dateUtil.nextDaySaturday(friday));
    }

    @Test
    void nextDaySaturdayFalse() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        Date thursday = sdf.parse("07/02/20"); // July 2, 2020 is a Thursday, next day is Friday
        assertFalse(dateUtil.nextDaySaturday(thursday));
    }

    @Test
    void previousDaySundayTrue() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        Date monday = sdf.parse("07/06/20"); // July 6, 2020 is a Monday, previous day is Sunday
        assertTrue(dateUtil.previousDaySunday(monday));
    }

    @Test
    void previousDaySundayFalse() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        Date tuesday = sdf.parse("07/07/20"); // July 7, 2020 is a Tuesday, previous day is Monday
        assertFalse(dateUtil.previousDaySunday(tuesday));
    }

    @Test
    void isFridayNextDayIndependenceDayTrue() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        Date friday = sdf.parse("07/03/26");
        assertTrue(dateUtil.isFridayNextDayIndependenceDay(friday));
    }

    @Test
    void isFridayNextDayIndependenceDayFalse() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        Date friday = sdf.parse("07/04/25");
        assertFalse(dateUtil.isFridayNextDayIndependenceDay(friday));
    }

    @Test
    void isMondayPreviousDayIndependenceDayTrue() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        Date monday = sdf.parse("07/05/21"); // July 5, 2021 is a Monday, previous day is July 4
        assertTrue(dateUtil.isMondayPreviousDayIndependenceDay(monday));
    }

    @Test
    void isMondayPreviousDayIndependenceDayFalse() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        Date tuesday = sdf.parse("07/06/21"); // July 6, 2021 is a Tuesday, previous day is July 5
        assertFalse(dateUtil.isMondayPreviousDayIndependenceDay(tuesday));
    }
}