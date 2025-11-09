package com.josephsPrograms.tool_rental.Service;

import com.josephsPrograms.tool_rental.DTO.RentalResponse;
import com.josephsPrograms.tool_rental.model.Tool;
import com.josephsPrograms.tool_rental.repository.InMemoryToolRepository;
import com.josephsPrograms.tool_rental.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;

@Service
public class ToolService {
    private final InMemoryToolRepository repository;

    @Autowired
    public ToolService(InMemoryToolRepository inMemoryToolRepository) {
        this.repository = inMemoryToolRepository;
    }

    public String getRentalAgreement(String toolCode, int rentalDayCount, int discountPercentage, String checkoutDate)
            throws IllegalArgumentException {

        Tool selectedTool = null;

        for (Tool tool : repository.getTools()) {
            if(tool.isCode(toolCode)) {
                selectedTool = tool;
            }
        }

        if(selectedTool == null) {
            throw new IllegalArgumentException("Tool code provided does not match any available tools. Tool Code provided: " + toolCode);
        }

        String dailyRentalCharge;
        String preDiscountCharge;
        String discountAmount;
        String finalCharge;
        String chargeableDays;

        NumberFormat usdFormat = NumberFormat.getCurrencyInstance(Locale.US);
        try {
            dailyRentalCharge = usdFormat.format(selectedTool.getDailyCharge());
            preDiscountCharge = usdFormat.format(selectedTool.calculatePreDiscountCharge(rentalDayCount, checkoutDate));
            discountAmount = usdFormat.format(selectedTool.calculateDiscountAmount(rentalDayCount, checkoutDate, discountPercentage));
            finalCharge = usdFormat.format(selectedTool.finalCharge(rentalDayCount, checkoutDate, discountPercentage));
            chargeableDays = String.valueOf(selectedTool.calculateChargeableDays(rentalDayCount, checkoutDate));
        } catch (IllegalArgumentException e) {
            String error = "Error processing Rental Agreement: \n" + e.getMessage();
            System.out.println(error);
            return error;
        }

        DateUtil dateUtil = new DateUtil();
        RentalResponse rentalResponse = new RentalResponse();
        rentalResponse.setToolCode(toolCode);
        rentalResponse.setToolType(selectedTool.getToolType());
        rentalResponse.setToolBrand(selectedTool.getToolBrand());
        rentalResponse.setRentalDays(String.valueOf(rentalDayCount));
        rentalResponse.setCheckoutDate(checkoutDate);
        rentalResponse.setDueDate(dateUtil.getDueDate(rentalDayCount, new Date(checkoutDate)));
        rentalResponse.setDailyRentalCharge(dailyRentalCharge);
        rentalResponse.setChargeDays(chargeableDays);
        rentalResponse.setPreDiscountCharge(preDiscountCharge);
        rentalResponse.setDiscountPercent(discountPercentage + "%");
        rentalResponse.setDiscountAmount(discountAmount);
        rentalResponse.setFinalCharge(finalCharge);

        return "Rental Agreement: \n" + rentalResponse.getRentalAgreement();
    }
}
