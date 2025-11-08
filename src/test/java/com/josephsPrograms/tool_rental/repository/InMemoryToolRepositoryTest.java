package com.josephsPrograms.tool_rental.repository;

import com.josephsPrograms.tool_rental.model.Tool;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class InMemoryToolRepositoryTest {

    @Test
    public void getTools_returnsExpectedTools() {
        InMemoryToolRepository repo = new InMemoryToolRepository();
        List<Tool> tools = repo.getTools();

        assertNotNull(tools);
        assertEquals(4, tools.size(), "repository should contain 4 tools");

        Tool t0 = tools.get(0);
        assertTrue(t0.isType("Ladder"));
        assertTrue(t0.isCode("LADW"));
        assertTrue(t0.isBrand("Werner"));
        assertEquals(0, t0.getDailyCharge().compareTo(java.math.BigDecimal.valueOf(1.99)));

        Tool t1 = tools.get(1);
        assertTrue(t1.isType("Chainsaw"));
        assertTrue(t1.isCode("CHNS"));
        assertTrue(t1.isBrand("Stihl"));
        assertEquals(0, t1.getDailyCharge().compareTo(java.math.BigDecimal.valueOf(1.49)));

        Tool t2 = tools.get(2);
        assertTrue(t2.isType("Jackhammer"));
        assertTrue(t2.isCode("JAKD"));
        assertTrue(t2.isBrand("DeWalt"));
        assertEquals(0, t2.getDailyCharge().compareTo(java.math.BigDecimal.valueOf(2.99)));

        Tool t3 = tools.get(3);
        assertTrue(t3.isType("Jackhammer"));
        assertTrue(t3.isCode("JAKR"));
        assertTrue(t3.isBrand("Ridgid"));
        assertEquals(0, t3.getDailyCharge().compareTo(java.math.BigDecimal.valueOf(2.99)));
    }
}

