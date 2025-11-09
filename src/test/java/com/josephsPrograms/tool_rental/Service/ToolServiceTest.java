package com.josephsPrograms.tool_rental.Service;

import com.josephsPrograms.tool_rental.repository.InMemoryToolRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ToolServiceTest {

    @Test
    public void getRentalAgreement_throwsExceptionForInvalidToolCode() {
        InMemoryToolRepository repo = new InMemoryToolRepository();
        ToolService service = new ToolService(repo);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.getRentalAgreement("INVALID_CODE", 5, 10, "07/02/25");
        });
        assertTrue(exception.getMessage().contains("Tool code provided does not match any available tools. Tool Code provided: INVALID_CODE"));
    }

    @Test
    public void getRentalAgreement_catchesExceptionForZeroRentalDaysAndReturnsIt() {
        InMemoryToolRepository repo = new InMemoryToolRepository();
        ToolService service = new ToolService(repo);
        String response = service.getRentalAgreement("JAKR", 0, 10, "07/02/25");
        assertTrue(response.contains("Rental day count must be at least 1. Provided count: 0"));
    }

    @Test
    public void getRentalAgreement_throwsExceptionForLessThanZeroDiscountPercentage() {
        InMemoryToolRepository repo = new InMemoryToolRepository();
        ToolService service = new ToolService(repo);
        String response = service.getRentalAgreement("JAKR", 1, -1, "07/02/25");
        assertTrue(response.contains("Discount percentage must be between 0 and 100. Provided percentage: -1"));
    }

    @Test
    public void getRentalAgreement_throwsExceptionForMoreThan100DiscountPercentage() {
        InMemoryToolRepository repo = new InMemoryToolRepository();
        ToolService service = new ToolService(repo);
        String response = service.getRentalAgreement("JAKR", 1, 101, "07/02/25");
        assertTrue(response.contains("Discount percentage must be between 0 and 100. Provided percentage: 101"));
    }
}
