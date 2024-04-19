package com.keita.second;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestTaskGenerator {
    // Test task generation
    @Test
    public void testTaskGeneration() {
        TaskGenerator generator = new TaskGenerator(5);
        Task task = generator.generateTask();
        assertEquals(0, task.getTaskId());  // First task ID should be 0
        assertTrue(task.getPriority() >= 0 && task.getPriority() <= 3);  // Priority should be between 0 and 3
    }
}