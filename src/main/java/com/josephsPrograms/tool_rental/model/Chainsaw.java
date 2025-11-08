package com.josephsPrograms.tool_rental.model;

import java.math.BigDecimal;

public class Chainsaw extends Tool {
    public Chainsaw(String toolCode, String brand) {
        super(
                toolCode,
                "Chainsaw",
                brand,
                BigDecimal.valueOf(1.49),
                true,
                false,
                true
        );
    }

    @Override
    public BigDecimal calculateCharge(int rentalDayCount, int discountPercentage, String checkoutDate) {
        return null;
    }
}
