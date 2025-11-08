package com.josephsPrograms.tool_rental.model;

import java.math.BigDecimal;

public abstract class Tool {

    protected String toolCode;
    protected String toolType;
    protected String brand;
    protected BigDecimal dailyCharge;
    protected boolean weekdayCharge;
    protected boolean weekendCharge;
    protected boolean holidayCharge;

    public Tool(String toolCode, String toolType, String brand,
                BigDecimal dailyCharge, boolean weekdayCharge,
                boolean weekendCharge, boolean holidayCharge
    ) {
        this.toolCode = toolCode;
        this.toolType = toolType;
        this.brand = brand;
        this.dailyCharge = dailyCharge;
        this.weekdayCharge = weekdayCharge;
        this.weekendCharge = weekendCharge;
        this.holidayCharge = holidayCharge;
    }

    public boolean isType(String type) {
        return this.toolType.equalsIgnoreCase(type);
    }

    public boolean isCode(String code){
        return this.toolCode.equalsIgnoreCase(code);
    }

    public boolean isBrand(String brand) {
        return this.brand.equalsIgnoreCase(brand);
    }

    public BigDecimal getDailyCharge() {
        return this.dailyCharge;
    }

    public boolean hasWeekdayCharge() {
        return this.weekdayCharge;
    }

    public boolean hasWeekendCharge() {
        return this.weekendCharge;
    }

    public boolean hasHolidayCharge() {
        return this.holidayCharge;
    }
}
