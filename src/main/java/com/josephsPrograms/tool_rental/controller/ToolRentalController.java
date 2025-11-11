package com.josephsPrograms.tool_rental.controller;

import com.josephsPrograms.tool_rental.DTO.RentalRequest;
import com.josephsPrograms.tool_rental.DTO.RentalResponse;
import com.josephsPrograms.tool_rental.Service.ToolService;
import com.josephsPrograms.tool_rental.repository.InMemoryToolRepository;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;


@RestController
@RequestMapping("/api")
public class ToolRentalController {

    private final InMemoryToolRepository repository;
    private final ToolService toolService;

    public ToolRentalController(InMemoryToolRepository repository, ToolService toolService) {
        this.repository = repository;
        this.toolService = toolService;
    }

    @PostMapping("/rent")
    public String createRental(@RequestBody(required = true) RentalRequest request) {
        if(request.getToolCode() == null || request.getToolCode().isEmpty())
            return "toolCode is required in the request body.";
        if(request.getCheckoutDate() == null || request.getCheckoutDate().isEmpty())
            return "checkoutDate is required in the request body.";
        try {
            String rentalResponse = this.toolService.getRentalAgreement(
                    request.getToolCode(),
                    request.getRentalDayCount(),
                    request.getDiscountPercentage(),
                    request.getCheckoutDate()
            );
            System.out.println("\n\n\n");
            System.out.println(rentalResponse);
            System.out.println("\n\n\n");
            return ResponseEntity.ok(rentalResponse).getBody();
        } catch (HttpMessageNotReadableException ex) {
            return handleHttpMessageNotReadable(ex).getBody();
        }
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<String> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            .body("Invalid or missing request body. Please provide a valid RentalRequest JSON.");
    }
}
