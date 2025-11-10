package com.josephsPrograms.tool_rental.controller;

import com.josephsPrograms.tool_rental.DTO.RentalRequest;
import com.josephsPrograms.tool_rental.Service.ToolService;
import com.josephsPrograms.tool_rental.repository.InMemoryToolRepository;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class ToolRentalController {

    private final InMemoryToolRepository repository;
    private final ToolService toolService;

    public ToolRentalController(InMemoryToolRepository repository, ToolService toolService) {
        this.repository = repository;
        this.toolService = toolService;
    }

    @GetMapping("/rent/{toolCode}/{rentalDayCount}/{discountPercentage}/{checkoutDate}")
    public String createRental(
        @PathVariable String toolCode,
        @PathVariable int rentalDayCount,
        @PathVariable int discountPercentage,
        @PathVariable String checkoutDate
    ) {
        return this.toolService.getRentalAgreement(
            toolCode,
            rentalDayCount,
            discountPercentage,
            checkoutDate
        );
    }
}
