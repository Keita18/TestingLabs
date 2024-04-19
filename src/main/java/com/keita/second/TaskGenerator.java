package com.keita.second;

import java.util.Random;

public class TaskGenerator {
    private final int maxTaskId;
    private int nextTaskId;
    private final Random random;

    public TaskGenerator(int maxTaskId) {
        this.maxTaskId = maxTaskId;
        this.nextTaskId = 0;
        this.random = new Random();
    }

    public Task generateTask() {
        if (nextTaskId > maxTaskId) {
            throw new IllegalStateException("Exceeded maximum task ID");
        }

        int taskId = nextTaskId;
        nextTaskId++;

        int priority = random.nextInt(4);
        String state = TaskState.READY;

        return new Task(taskId, priority, state);
    }
}