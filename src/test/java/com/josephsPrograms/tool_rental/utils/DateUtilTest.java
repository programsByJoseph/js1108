package com.josephsPrograms.tool_rental.utils;

import org.junit.jupiter.api.Test;

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

    @Test
    void isLaborDayTrue() {
        assertTrue(this.dateUtil.isLaborDay("09/01/25"));
    }

    @Test
    void isLaborDayFalse() {
        assertFalse(this.dateUtil.isLaborDay("09/08/25"));
    }

    @Test
    void weekdaysInRentalNoWeekdays() {
        int weekdays = this.dateUtil.weekdaysInRental(2, "07/05/25");
        assertEquals(0, weekdays);
    }

    @Test
    void weekdaysInRentalHasWeekdays() {
        int weekdays = this.dateUtil.weekdaysInRental(3, "07/04/25");
        assertEquals(1, weekdays);
    }

    @Test
    void weekendDaysInRentalNoWeekends() {
        int weekendDays = this.dateUtil.weekendDaysInRental(1, "07/04/25");
        assertEquals(0, weekendDays);
    }

    @Test
    void weekendDaysInRentalHasWeekends() {
        int weekendDays = this.dateUtil.weekendDaysInRental(3, "07/04/25");
        assertEquals(2, weekendDays);
    }

    @Test
    void dueDateCalculatesCorrectly() {
        String dueDate = this.dateUtil.getDueDate(3, "07/04/25");
        assertEquals("07/06/25", dueDate);
    }

    @Test
    void dueDateCalculatesMonthChangeCorrectly() {
        String dueDate = this.dateUtil.getDueDate(3, "07/30/25");
        assertEquals("08/01/25", dueDate);
    }

    @Test
    void chargeableDaysWithWeekdayWithWeekendWithoutHoliday() {
        int chargeableDays = this.dateUtil.chargeableDays(5, "11/03/25", true, true, false);
        assertEquals(5, chargeableDays);
    }

//    @Test
//    void chargeableDaysWithWeekdayWithWeekendWithHoliday() {
//        int chargeableDays = this.dateUtil.chargeableDays(6, "07/01/25", true, true, false);
//        assertEquals(5, chargeableDays);
//    }
}