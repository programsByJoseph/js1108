package com.josephsPrograms.tool_rental.model;

import com.josephsPrograms.tool_rental.utils.DateUtil;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Ladder extends Tool {
    public Ladder(String toolCode, String brand) {
        super(
                toolCode,
                "Ladder",
                brand,
                BigDecimal.valueOf(1.99)
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
                boolean isFridayNextDayIndependenceDay = dateUtil.isFridayNextDayIndependenceDay(cal.getTime());
                boolean isMondayPreviousDayIndependenceDay = dateUtil.isMondayPreviousDayIndependenceDay(cal.getTime());
                if(!isLaborDay && !isFridayNextDayIndependenceDay && !isMondayPreviousDayIndependenceDay) {
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
        // Therefore, subtract 1 from the total chargeable days calculated to not include the day of checkout
        // because "from day after checkout..."
//        int chargeableDaysExcludingFirstDay = chargeableDays - 1;
//        return chargeableDaysExcludingFirstDay < 0 ? 0 : chargeableDaysExcludingFirstDay;
        return chargeableDays;
    }
}

//● Due date - Calculated from checkout date and rental days.
//● Charge days - Count of chargeable days, from day after checkout through and including due
//date, excluding “no charge” days as specified by the tool type.
//● Pre-discount charge - Calculated as charge days X daily charge. The resulting total rounded half
//up to cents.
//● Discount amount - calculated from discount % and pre-discount charge.  The resulting amount
//rounded half up to cents.
//● Final charge - Calculated as pre-discount charge - discount amount.
