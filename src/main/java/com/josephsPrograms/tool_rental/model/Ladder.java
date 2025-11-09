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
        DateUtil dateUtil = new DateUtil();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
        int chargeableDays = 0;
        boolean independenceDayUsed = false;
        try {
            Date startDate = sdf.parse(checkoutDate);
            Calendar cal = Calendar.getInstance();
            cal.setTime(startDate);
            for (int i = 0; i < rentalDays; ++i) {
                boolean isIndependenceDay = dateUtil.isIndependenceDay(cal.getTime());
                boolean isLaborDay = dateUtil.isLaborDay(cal.getTime());
                boolean isHoliday = isIndependenceDay || isLaborDay;
                boolean isFridayNextDayIndependenceDay = dateUtil.isFridayNextDayIndependenceDay(cal.getTime());
                boolean isMondayPreviousDayIndependenceDay = dateUtil.isMondayPreviousDayIndependenceDay(cal.getTime());
                if((!isHoliday && !isFridayNextDayIndependenceDay && !isMondayPreviousDayIndependenceDay) || independenceDayUsed) {
                    chargeableDays += 1;
                } else {
                    independenceDayUsed = true;
                }
                cal.add(Calendar.DAY_OF_MONTH, 1);
            }
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException("Invalid date format");
        }
        int chargeableDaysExludingFirstDay = chargeableDays - 1;
        return chargeableDaysExludingFirstDay < 0 ? 0 : chargeableDaysExludingFirstDay;
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
