package com.josephsPrograms.tool_rental.controller;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.josephsPrograms.tool_rental.Service.ToolService;
import com.josephsPrograms.tool_rental.DTO.RentalRequest;
import com.josephsPrograms.tool_rental.repository.InMemoryToolRepository;
import static org.mockito.Mockito.*;
import org.springframework.http.MediaType;

@WebMvcTest(ToolRentalController.class)
class ToolRentalControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ToolService toolService;

    @MockBean
    private InMemoryToolRepository repository;

    // This is simply a test that when the endpoint is called, it interacts with the service layer as expected.
    // The actual logic of creating a test rental agreement is tested in the ToolServiceTest.
    @Test
    void createRental() throws Exception {
        String expectedAgreement = "Rental Agreement";
        when(toolService.getRentalAgreement("JAKR", 6, 0, "09/03/15")).thenReturn(expectedAgreement);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/rent")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"toolCode\":\"JAKR\",\"rentalDayCount\":6,\"discountPercentage\":0,\"checkoutDate\":\"09/03/15\"}"))
                .andExpect(MockMvcResultMatchers.content().string(expectedAgreement));
    }

    @Test
    void createRental_requestBodyMissingToolCode() throws Exception {
        String expectedAgreement = "toolCode is required in the request body.";
        when(toolService.getRentalAgreement("JAKR", 6, 0, "09/03/15")).thenReturn(expectedAgreement);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/rent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"rentalDayCount\":6,\"discountPercentage\":0,\"checkoutDate\":\"09/03/15\"}"))
                .andExpect(MockMvcResultMatchers.content().string(expectedAgreement));
    }

    @Test
    void createRental_requestBodyMissingCheckoutDate() throws Exception {
        String expectedAgreement = "checkoutDate is required in the request body.";
        when(toolService.getRentalAgreement("JAKR", 6, 0, "09/03/15")).thenReturn(expectedAgreement);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/rent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"toolCode\":\"JAKR\",\"rentalDayCount\":6,\"discountPercentage\":0}"))
                .andExpect(MockMvcResultMatchers.content().string(expectedAgreement));
    }

    @Test
    void createRental_noRequestBody() throws Exception {
        String expectedAgreement = "Invalid or missing request body. Please provide a valid RentalRequest JSON.";
        when(toolService.getRentalAgreement("JAKR", 6, 0, "09/03/15")).thenReturn(expectedAgreement);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/rent")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(""))
                .andExpect(MockMvcResultMatchers.content().string(expectedAgreement));
    }
}