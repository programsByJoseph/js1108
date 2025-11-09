package com.josephsPrograms.tool_rental.DTO;

public class RentalResponse {

    private String toolCode;
    private String toolType;
    private String toolBrand;
    private String rentalDays;
    private String checkoutDate;
    private String dueDate;
    private String dailyRentalCharge;
    private String chargeDays;
    private String preDiscountCharge;
    private String discountPercent;
    private String discountAmount;
    private String finalCharge;

    public String getToolCode() { return toolCode; }
    public void setToolCode(String toolCode) { this.toolCode = toolCode; }

    public String getToolType() { return toolType; }
    public void setToolType(String toolType) { this.toolType = toolType; }

    public String getToolBrand() { return toolBrand; }
    public void setToolBrand(String toolBrand) { this.toolBrand = toolBrand; }

    public String getRentalDays() { return rentalDays; }
    public void setRentalDays(String rentalDays) { this.rentalDays = rentalDays; }

    public String getCheckoutDate() { return checkoutDate; }
    public void setCheckoutDate(String checkoutDate) { this.checkoutDate = checkoutDate; }

    public String getDueDate() { return dueDate; }
    public void setDueDate(String dueDate) { this.dueDate = dueDate; }

    public String getDailyRentalCharge() { return dailyRentalCharge; }
    public void setDailyRentalCharge(String dailyRentalCharge) { this.dailyRentalCharge = dailyRentalCharge; }

    public String getChargeDays() { return chargeDays; }
    public void setChargeDays(String chargeDays) { this.chargeDays = chargeDays; }

    public String getPreDiscountCharge() { return preDiscountCharge; }
    public void setPreDiscountCharge(String preDiscountCharge) { this.preDiscountCharge = preDiscountCharge; }

    public String getDiscountPercent() { return discountPercent; }
    public void setDiscountPercent(String discountPercent) { this.discountPercent = discountPercent; }

    public String getDiscountAmount() { return discountAmount; }
    public void setDiscountAmount(String discountAmount) { this.discountAmount = discountAmount; }

    public String getFinalCharge() { return finalCharge; }
    public void setFinalCharge(String finalCharge) { this.finalCharge = finalCharge; }

    @Override
    public String toString() {
        return "Tool Code: " + toolCode + '\n' +
                "Tool Type: " + toolType + '\n' +
                "Tool Brand: " + toolBrand + '\n' +
                "Rental Days: " + rentalDays + '\n' +
                "Checkout Date: " + checkoutDate + '\n' +
                "Due Date: " + dueDate + '\n' +
                "Daily Rental Charge: " + dailyRentalCharge + '\n' +
                "Charge Days: " + chargeDays + '\n' +
                "Pre Discount Charge: " + preDiscountCharge + '\n' +
                "Discount Percentage: " + discountPercent + '\n' +
                "Discount Amount: " + discountAmount + '\n' +
                "Final Charge: " + finalCharge + '\n';
    }

    public String getRentalAgreement() {
        return this.toString();
    }
}
