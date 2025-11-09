package com.josephsPrograms.tool_rental.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public abstract class Tool {

    protected String toolCode;
    protected String toolType;
    protected String brand;
    protected BigDecimal dailyCharge;

    public Tool(String toolCode, String toolType, String brand,
                BigDecimal dailyCharge
    ) {
        this.toolCode = toolCode;
        this.toolType = toolType;
        this.brand = brand;
        this.dailyCharge = dailyCharge;
    }

    public boolean isType(String type) {
        return this.toolType.equalsIgnoreCase(type);
    }

    public boolean isCode(String code) {
        return this.toolCode.equalsIgnoreCase(code);
    }

    public boolean isBrand(String brand) {
        return this.brand.equalsIgnoreCase(brand);
    }

    public BigDecimal getDailyCharge() {
        return this.dailyCharge;
    }

    public BigDecimal calculatePreDiscountCharge(int rentalDayCount, String checkoutDate) {
        BigDecimal chargeableDays = new BigDecimal(this.calculateChargeableDays(rentalDayCount, checkoutDate));
        return this.dailyCharge.multiply(chargeableDays);
    }

    public BigDecimal calculateDiscountAmount(BigDecimal preDiscountCharge, int discountPercentage) {
        BigDecimal discountPercentageAsDecimal = new BigDecimal(discountPercentage).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
        return preDiscountCharge.multiply(discountPercentageAsDecimal).setScale(2, RoundingMode.HALF_UP);
    }

    public BigDecimal finalCharge(BigDecimal preDiscountCharge,  BigDecimal discountAmount) {
        return preDiscountCharge.subtract(discountAmount).setScale(2, RoundingMode.HALF_UP);
    }

    public abstract int calculateChargeableDays(int rentalDays, String checkoutDate);
}
