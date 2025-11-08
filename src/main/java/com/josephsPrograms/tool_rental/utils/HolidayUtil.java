package com.josephsPrograms.tool_rental.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class HolidayUtil {

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
}
