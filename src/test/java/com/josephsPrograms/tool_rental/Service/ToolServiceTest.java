package com.josephsPrograms.tool_rental.Service;

import com.josephsPrograms.tool_rental.repository.InMemoryToolRepository;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ToolServiceTest {

    @Test
    public void getRentalAgreement_returnsEmptyString() {
        InMemoryToolRepository repo = new InMemoryToolRepository();
        ToolService service = new ToolService(repo);
        String result = service.getRentalAgreement("CHNS", 5, 10, "2025-07-02");
        assertEquals("", result);
    }
}

