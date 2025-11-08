package com.josephsPrograms.tool_rental.Service;

import com.josephsPrograms.tool_rental.repository.InMemoryToolRepository;
import org.springframework.stereotype.Service;

@Service
public class ToolService {
    private final InMemoryToolRepository inMemoryToolRepository;

    public ToolService(InMemoryToolRepository inMemoryToolRepository) {
        this.inMemoryToolRepository = inMemoryToolRepository;
    }
}
