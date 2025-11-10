package com.josephsPrograms.tool_rental.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    //Based on interpretation of requirement description:
    //"Due date - Calculated from checkout date and rental days."
    //One day should span two dates. For example, if a tool is checked out on 7/2 for 1 day
    //it is due back on 7/3.
    public String getDueDate(int rentalDays, Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_MONTH, rentalDays);
        Date dueDate = cal.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        return sdf.format(dueDate);
    }

    public String formatCheckoutDate(String checkoutDate) throws IllegalArgumentException {
        String modifiedDate = checkoutDate.replace("-", "/");
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        try {
            Date date = sdf.parse(modifiedDate);
            return sdf.format(date);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format: \n" + e.getMessage());
        }
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
