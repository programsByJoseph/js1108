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
                BigDecimal.valueOf(1.99),
                true,
                true,
                false
        );
    }

    @Override
    public BigDecimal calculateCharge(int rentalDayCount, int discountPercentage, String checkoutDate) {
        return this.dailyCharge.multiply(new BigDecimal(rentalDayCount));
    }

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
                if(!dayIsIndependenceDay) {
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

//Tool code - As specified at checkout
//● Tool type - From tool information
//● Tool brand - From tool information
//● Rental days - As specified at checkout
//● Checkout date  - As specified at checkout
//● Due date - Calculated from checkout date and rental days.
//● Daily rental charge - Amount per day, specified by the tool type.
//● Charge days - Count of chargeable days, from day after checkout through and including due
//date, excluding “no charge” days as specified by the tool type.
//● Pre-discount charge - Calculated as charge days X daily charge. The resulting total rounded half
//up to cents.
//● Discount percent - Specified at checkout.
//● Discount amount - calculated from discount % and pre-discount charge.  The resulting amount
//rounded half up to cents.
//● Final charge - Calculated as pre-discount charge - discount amount.
