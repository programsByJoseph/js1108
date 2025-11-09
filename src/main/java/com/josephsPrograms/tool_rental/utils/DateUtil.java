package com.josephsPrograms.tool_rental.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    //Due date is calculated INCLUDING the day of the checkout
    public String getDueDate(int rentalDays, String checkoutDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        String dueDateString;
        try {
            Date date = sdf.parse(checkoutDate);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.DAY_OF_MONTH, rentalDays);
            dueDateString = sdf.format(cal.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("Invalid date format");
        }
        return dueDateString;
    }

    public boolean dayIsWeekday(Date currentDay) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDay);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY;
    }

    public boolean dayIsWeekend(Date currentDay) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDay);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY;
    }

    public int chargeableDays(int rentalDays, String checkoutDate, boolean weekdayCharge, boolean weekendCharge, boolean holidayCharge) {
        int chargeableDays = 0;
        int weekends = weekendDaysInRental(rentalDays, checkoutDate);
        int weekdays = weekdaysInRental(rentalDays, checkoutDate);
        int holidays = 0; // Holiday calculation can be added here if needed

        if (weekdayCharge) {
            chargeableDays += weekdays;
        }
        if (weekendCharge) {
            chargeableDays += weekends;
        }
        if (holidayCharge) {
            chargeableDays += holidays;
        }

        return chargeableDays;
    }

    public boolean isIndependenceDay(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        boolean isIndependenceDay = false;
        try {
            Date date = sdf.parse(dateString);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int month = cal.get(Calendar.MONTH) + 1;
            int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
            isIndependenceDay = (month == 7 && dayOfMonth == 4);
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("Invalid date format");
        }
        return isIndependenceDay;
    }

    public boolean isIndependenceDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH) + 1;
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        return (month == 7 && dayOfMonth == 4);
    }

    public boolean isLaborDay(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        boolean isLaborDay = false;
        try {
            Date date = sdf.parse(dateString);
            Calendar cal = Calendar.getInstance();
            cal.setTime(date);
            int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
            int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
            int month = cal.get(Calendar.MONTH) + 1;
            isLaborDay = month == 9 && dayOfWeek == Calendar.MONDAY && dayOfMonth <= 7;
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("Invalid date format");
        }
        return isLaborDay;
    }

    public int weekdaysInRental(int rentalDayCount, String checkoutDay) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        int weekdays = 0;
        try {
            Date startDate = sdf.parse(checkoutDay);
            Calendar cal = Calendar.getInstance();
            cal.setTime(startDate);
            for (int i = 0; i < rentalDayCount; ++i) {
                int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
                if (dayOfWeek != Calendar.SATURDAY && dayOfWeek != Calendar.SUNDAY) {
                    ++weekdays;
                }
                cal.add(Calendar.DAY_OF_MONTH, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("Invalid date format");
        }
        return weekdays;
    }

    public int weekendDaysInRental(int rentalDayCount, String checkoutDay) {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        int weekends = 0;
        try {
            Date startDate = sdf.parse(checkoutDay);
            Calendar cal = Calendar.getInstance();
            cal.setTime(startDate);
            for (int i = 0; i < rentalDayCount; ++i) {
                int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
                if (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY) {
                    ++weekends;
                }
                cal.add(Calendar.DAY_OF_MONTH, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("Invalid date format");
        }
        return weekends;
    }
}
