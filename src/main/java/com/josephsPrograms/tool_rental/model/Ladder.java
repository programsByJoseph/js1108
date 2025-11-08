package com.josephsPrograms.tool_rental.model;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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

        return null;
    }
}
