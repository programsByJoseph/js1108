package com.josephsPrograms.tool_rental.model;

import com.josephsPrograms.tool_rental.utils.DateUtil;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Jackhammer extends Tool {
    public Jackhammer(String toolCode, String brand) {
        super(
                toolCode,
                "Jackhammer",
                brand,
                BigDecimal.valueOf(2.99)
        );
    }

    @Override
    public int calculateChargeableDays(int rentalDays, String checkoutDate) {
        if(rentalDays < 1) {
            throw new IllegalArgumentException("Rental day count must be at least 1. Provided count: " + rentalDays);
        }

        DateUtil dateUtil = new DateUtil();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        int chargeableDays = 0;
        try {
            Date startDate = sdf.parse(checkoutDate);
            Calendar cal = Calendar.getInstance();
            cal.setTime(startDate);
            cal.add(Calendar.DAY_OF_MONTH, 1);
            for (int i = 0; i < rentalDays; ++i) {
                boolean isLaborDay = dateUtil.isLaborDay(cal.getTime());
                boolean isIndependenceDay = dateUtil.isIndependenceDay(cal.getTime());
                boolean isWeekday = dateUtil.dayIsWeekday(cal.getTime());
                boolean fridayNextDayIndependenceDay = dateUtil.isFridayNextDayIndependenceDay(cal.getTime());
                boolean mondayPreviousDayIndependenceDay = dateUtil.isMondayPreviousDayIndependenceDay(cal.getTime());
                if(isWeekday && !isLaborDay && !isIndependenceDay &&
                        !fridayNextDayIndependenceDay && !mondayPreviousDayIndependenceDay
                ) {
                    chargeableDays += 1;
                }
                cal.add(Calendar.DAY_OF_MONTH, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("Invalid date format");
        }

        return chargeableDays;
    }
}
