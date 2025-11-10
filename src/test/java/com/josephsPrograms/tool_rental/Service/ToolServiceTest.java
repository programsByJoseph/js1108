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

    @Test
    public void getRentalAgreement_validInputReturnsAgreementValidationTest1() {
        System.out.println("\n\n\n");
        System.out.println("EXERCISE TEST 1 OUTPUT");
        System.out.println("\n");
        InMemoryToolRepository repo = new InMemoryToolRepository();
        ToolService service = new ToolService(repo);
        String result = service.getRentalAgreement("JAKR", 5, 101, "9/3/15");
        assertNotNull(result);
        assertTrue(result.contains("Discount percentage must be between 0 and 100. Provided percentage: 101"));
    }

    @Test
    public void getRentalAgreement_validInputReturnsAgreementValidationTest2() {
        System.out.println("\n\n\n");
        System.out.println("EXERCISE TEST 2 OUTPUT");
        System.out.println("\n");
        InMemoryToolRepository repo = new InMemoryToolRepository();
        ToolService service = new ToolService(repo);
        String result = service.getRentalAgreement("LADW", 3, 10, "7/2/20");
        assertNotNull(result);
        System.out.println(result);
        assertTrue(result.startsWith("Rental Agreement:"));
        assertTrue(result.contains("Tool Code: LADW"));
        assertTrue(result.contains("Tool Type: Ladder"));
        assertTrue(result.contains("Tool Brand: Werner"));
        assertTrue(result.contains("Rental Days: 3"));
        assertTrue(result.contains("Checkout Date: 07/02/20"));
        assertTrue(result.contains("Due Date: 07/05/20"));
        assertTrue(result.contains("Daily Rental Charge: $1.99"));
        assertTrue(result.contains("Charge Days: 2"));
        assertTrue(result.contains("Pre Discount Charge: $3.98"));
        assertTrue(result.contains("Discount Percentage: 10%"));
        assertTrue(result.contains("Discount Amount: $0.4"));
        assertTrue(result.contains("Final Charge: $3.58"));
    }

    @Test
    public void getRentalAgreement_validInputReturnsAgreementValidationTest2ExtraValidation() {
        InMemoryToolRepository repo = new InMemoryToolRepository();
        ToolService service = new ToolService(repo);
        String result = service.getRentalAgreement("LADW", 5, 10, "7/2/20");
        assertNotNull(result);
        assertTrue(result.startsWith("Rental Agreement:"));
        assertTrue(result.contains("Tool Code: LADW"));
        assertTrue(result.contains("Tool Type: Ladder"));
        assertTrue(result.contains("Tool Brand: Werner"));
        assertTrue(result.contains("Rental Days: 5"));
        assertTrue(result.contains("Checkout Date: 07/02/20"));
        assertTrue(result.contains("Due Date: 07/07/20"));
        assertTrue(result.contains("Daily Rental Charge: $1.99"));
        assertTrue(result.contains("Charge Days: 4"));
        assertTrue(result.contains("Pre Discount Charge: $7.96"));
        assertTrue(result.contains("Discount Percentage: 10%"));
        assertTrue(result.contains("Discount Amount: $0.8"));
        assertTrue(result.contains("Final Charge: $7.16"));
    }

    @Test
    public void getRentalAgreement_validInputReturnsAgreementValidationTest3() {
        System.out.println("\n\n\n");
        System.out.println("EXERCISE TEST 3 OUTPUT");
        System.out.println("\n");
        InMemoryToolRepository repo = new InMemoryToolRepository();
        ToolService service = new ToolService(repo);
        String result = service.getRentalAgreement("CHNS", 5, 25, "7/2/15");
        assertNotNull(result);
        System.out.println(result);
        assertTrue(result.startsWith("Rental Agreement:"));
        assertTrue(result.contains("Tool Code: CHNS"));
        assertTrue(result.contains("Tool Type: Chainsaw"));
        assertTrue(result.contains("Tool Brand: Stihl"));
        assertTrue(result.contains("Rental Days: 5"));
        assertTrue(result.contains("Checkout Date: 07/02/15"));
        assertTrue(result.contains("Due Date: 07/07/15"));
        assertTrue(result.contains("Daily Rental Charge: $1.49"));
        assertTrue(result.contains("Charge Days: 3"));
        assertTrue(result.contains("Pre Discount Charge: $4.47"));
        assertTrue(result.contains("Discount Percentage: 25%"));
        assertTrue(result.contains("Discount Amount: $1.12"));
        assertTrue(result.contains("Final Charge: $3.35"));
    }

    @Test
    public void getRentalAgreement_validInputReturnsAgreementValidationTest4() {
        System.out.println("\n\n\n");
        System.out.println("EXERCISE TEST 4 OUTPUT");
        System.out.println("\n");
        InMemoryToolRepository repo = new InMemoryToolRepository();
        ToolService service = new ToolService(repo);
        String result = service.getRentalAgreement("JAKD", 6, 0, "9/3/15");
        assertNotNull(result);
        System.out.println(result);
        assertTrue(result.startsWith("Rental Agreement:"));
        assertTrue(result.contains("Tool Code: JAKD"));
        assertTrue(result.contains("Tool Type: Jackhammer"));
        assertTrue(result.contains("Tool Brand: DeWalt"));
        assertTrue(result.contains("Rental Days: 6"));
        assertTrue(result.contains("Checkout Date: 09/03/15"));
        assertTrue(result.contains("Due Date: 09/09/15"));
        assertTrue(result.contains("Daily Rental Charge: $2.99"));
        assertTrue(result.contains("Charge Days: 3"));
        assertTrue(result.contains("Pre Discount Charge: $8.97"));
        assertTrue(result.contains("Discount Percentage: 0%"));
        assertTrue(result.contains("Discount Amount: $0.00"));
        assertTrue(result.contains("Final Charge: $8.97"));
    }

    @Test
    public void getRentalAgreement_validInputReturnsAgreementValidationTest5() {
        System.out.println("\n\n\n");
        System.out.println("EXERCISE TEST 5 OUTPUT");
        System.out.println("\n");
        InMemoryToolRepository repo = new InMemoryToolRepository();
        ToolService service = new ToolService(repo);
        String result = service.getRentalAgreement("JAKR", 9, 0, "7/2/15");
        assertNotNull(result);
        System.out.println(result);
        assertTrue(result.startsWith("Rental Agreement:"));
        assertTrue(result.contains("Tool Code: JAKR"));
        assertTrue(result.contains("Tool Type: Jackhammer"));
        assertTrue(result.contains("Tool Brand: Ridgid"));
        assertTrue(result.contains("Rental Days: 9"));
        assertTrue(result.contains("Checkout Date: 07/02/15"));
        assertTrue(result.contains("Due Date: 07/11/15"));
        assertTrue(result.contains("Daily Rental Charge: $2.99"));
        assertTrue(result.contains("Charge Days: 5"));
        assertTrue(result.contains("Pre Discount Charge: $14.95"));
        assertTrue(result.contains("Discount Percentage: 0%"));
        assertTrue(result.contains("Discount Amount: $0.00"));
        assertTrue(result.contains("Final Charge: $14.95"));
    }

    @Test
    public void getRentalAgreement_validInputReturnsAgreementValidationTest6() {
        System.out.println("\n\n\n");
        System.out.println("EXERCISE TEST 6 OUTPUT");
        System.out.println("\n");
        InMemoryToolRepository repo = new InMemoryToolRepository();
        ToolService service = new ToolService(repo);
        String result = service.getRentalAgreement("JAKR", 4, 50, "7/2/20");
        assertNotNull(result);
        System.out.println(result);
        assertTrue(result.startsWith("Rental Agreement:"));
        assertTrue(result.contains("Tool Code: JAKR"));
        assertTrue(result.contains("Tool Type: Jackhammer"));
        assertTrue(result.contains("Tool Brand: Ridgid"));
        assertTrue(result.contains("Rental Days: 4"));
        assertTrue(result.contains("Checkout Date: 07/02/20"));
        assertTrue(result.contains("Due Date: 07/06/20"));
        assertTrue(result.contains("Daily Rental Charge: $2.99"));
        assertTrue(result.contains("Charge Days: 1"));
        assertTrue(result.contains("Pre Discount Charge: $2.99"));
        assertTrue(result.contains("Discount Percentage: 50%"));
        assertTrue(result.contains("Discount Amount: $1.50"));
        assertTrue(result.contains("Final Charge: $1.49"));
    }
}
