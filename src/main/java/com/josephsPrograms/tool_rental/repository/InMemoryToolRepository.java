package com.josephsPrograms.tool_rental.repository;

import com.josephsPrograms.tool_rental.model.Ladder;
import com.josephsPrograms.tool_rental.model.*;

import java.util.ArrayList;
import java.util.List;

public class InMemoryToolRepository {
    private final List<Tool> tools = new ArrayList<>();

    public InMemoryToolRepository() {
        tools.add(new Ladder("LADW", "Werner"));
        tools.add(new Chainsaw("CHNS", "Stihl"));
        tools.add(new Jackhammer("JAKD", "DeWalt"));
        tools.add(new Jackhammer("JAKR", "Ridgid"));
    }

    public List<Tool> getTools() {
        return tools;
    }
}
