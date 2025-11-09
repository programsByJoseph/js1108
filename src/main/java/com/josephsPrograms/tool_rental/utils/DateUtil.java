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

    public boolean isIndependenceDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH) + 1;
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        return (month == 7 && dayOfMonth == 4);
    }

    public boolean isLaborDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        int month = cal.get(Calendar.MONTH) + 1;
        return month == 9 && dayOfWeek == Calendar.MONDAY && dayOfMonth <= 7;
    }

    public boolean isFridayNextDayIndependenceDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int currentDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);

        cal.add(Calendar.DAY_OF_MONTH, 1);
        int month = cal.get(Calendar.MONTH) + 1;
        int nextDayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        return currentDayOfWeek == Calendar.FRIDAY && month == 7 && nextDayOfMonth == 4;
    }

    public boolean isMondayPreviousDayIndependenceDay(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int currentDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DAY_OF_MONTH, -1);
        int month = cal.get(Calendar.MONTH) + 1;
        int prevDayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
        return currentDayOfWeek == Calendar.MONDAY && month == 7 && prevDayOfMonth == 4;
    }
}
