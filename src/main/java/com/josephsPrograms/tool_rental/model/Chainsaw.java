package com.josephsPrograms.tool_rental.model;

import com.josephsPrograms.tool_rental.utils.DateUtil;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Chainsaw extends Tool {
    public Chainsaw(String toolCode, String brand) {
        super(
                toolCode,
                "Chainsaw",
                brand,
                BigDecimal.valueOf(1.49)
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
            for (int i = 0; i < rentalDays; ++i) {
                boolean isWeekday = dateUtil.dayIsWeekday(cal.getTime());
                if(isWeekday) {
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
