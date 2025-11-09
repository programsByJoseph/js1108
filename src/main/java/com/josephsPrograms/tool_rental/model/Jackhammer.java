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
        DateUtil dateUtil = new DateUtil();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        int chargeableDays = 0;
        try {
            Date startDate = sdf.parse(checkoutDate);
            Calendar cal = Calendar.getInstance();
            cal.setTime(startDate);
            for (int i = 0; i < rentalDays; ++i) {
                boolean dayIsIndependenceDay = dateUtil.isIndependenceDay(cal.getTime());
                boolean isLaborDay = dateUtil.isLaborDay(cal.getTime());
                boolean isWeekday = dateUtil.dayIsWeekday(cal.getTime());
                boolean fridayNextDayIndependenceDay = dateUtil.isFridayNextDayIndependenceDay(cal.getTime());
                boolean mondayPreviousDayIndependenceDay = dateUtil.isMondayPreviousDayIndependenceDay(cal.getTime());
                if(isWeekday && !isLaborDay && !dayIsIndependenceDay &&
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

        // Exclude the checkout day based on interpretation of requirement description:
        // "Charge days - Count of chargeable days, from day after checkout through and including due date..."
        // Therefore, we subtract 1 from the total chargeable days calculated to not include the day of checkout
        // because "from day after checkout..."
        int chargeableDaysExcludingFirstDay = chargeableDays - 1;
        return chargeableDaysExcludingFirstDay < 0 ? 0 : chargeableDaysExcludingFirstDay;
    }
}
