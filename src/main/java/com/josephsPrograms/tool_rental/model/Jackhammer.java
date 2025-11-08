package com.josephsPrograms.tool_rental.model;

import java.math.BigDecimal;

public class Jackhammer extends Tool {
    public Jackhammer(String toolCode, String brand) {
        super(
                toolCode,
                "Jackhammer",
                brand,
                BigDecimal.valueOf(2.99),
                true,
                false,
                false
        );
    }
}
