package com.josephsPrograms.tool_rental.Service;

import com.josephsPrograms.tool_rental.repository.InMemoryToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToolService {
    private final InMemoryToolRepository repository;

    @Autowired
    public ToolService(InMemoryToolRepository inMemoryToolRepository) {
        this.repository = inMemoryToolRepository;
    }

    public String getRentalAgreement(String toolCode, int rentalDayCount, int discountPercentage, String checkoutDate) {

        return "";
    }
}
