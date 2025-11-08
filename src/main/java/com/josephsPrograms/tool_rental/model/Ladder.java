package com.josephsPrograms.tool_rental.model;

import java.math.BigDecimal;

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
}
