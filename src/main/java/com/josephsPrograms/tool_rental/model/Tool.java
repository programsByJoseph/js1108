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

    // Pre-discount charge - Calculated as charge days X daily charge. The resulting total rounded half
    // up to cents.
    public BigDecimal calculatePreDiscountCharge(int rentalDayCount, String checkoutDate) {
        BigDecimal chargeableDays = new BigDecimal(this.calculateChargeableDays(rentalDayCount, checkoutDate));
        return this.dailyCharge.multiply(chargeableDays).setScale(2, RoundingMode.HALF_UP);
    }

    // Discount amount - calculated from discount % and pre-discount charge.  The resulting amount
    // rounded half up to cents.
    public BigDecimal calculateDiscountAmount(int rentalDayCount, String checkoutDate, int discountPercentage) {
        BigDecimal discountPercentageAsDecimal = new BigDecimal(discountPercentage).divide(new BigDecimal(100), 2, RoundingMode.HALF_UP);
        BigDecimal preDiscountCharge = this.calculatePreDiscountCharge(rentalDayCount, checkoutDate);
        return preDiscountCharge.multiply(discountPercentageAsDecimal).setScale(2, RoundingMode.HALF_UP);
    }

    // Final charge - Calculated as pre-discount charge - discount amount.
    public BigDecimal finalCharge(int rentalDayCount, String checkoutDate, int discountPercentage) {
        BigDecimal discountAmount = this.calculateDiscountAmount(rentalDayCount, checkoutDate,discountPercentage);
        return this.calculatePreDiscountCharge(rentalDayCount, checkoutDate).subtract(discountAmount).setScale(2, RoundingMode.HALF_UP);
    }

    public abstract int calculateChargeableDays(int rentalDays, String checkoutDate);
}
