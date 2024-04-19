package com.keita.second;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class TestTaskManager {
    // Test task activation
    @Test
    public void testTaskActivation() {
        TaskManager manager = new TaskManager();
        Task task = new Task(1, 2, TaskState.SUSPENDED);
        manager.addTask(task);
        manager.activateTask(1);
        assertEquals(TaskState.READY, manager.getTasks().get(1).getState());
    }

    // Test task starting
    @Test
    public void testTaskStarting() {
        TaskManager manager = new TaskManager();
        Task task = new Task(1, 2, TaskState.READY);
        manager.addTask(task);
        manager.startTask(1);
        assertEquals(TaskState.RUNNING, manager.getTasks().get(1).getState());
    }

    // Test task waiting
    @Test
    public void testTaskWaiting() {
        TaskManager manager = new TaskManager();
        Task task = new Task(1, 2, TaskState.RUNNING);
        manager.addTask(task);
        manager.waitTask(1);
        assertEquals(TaskState.WAITING, manager.getTasks().get(1).getState());
    }

    // Test task releasing
    @Test
    public void testTaskReleasing() {
        TaskManager manager = new TaskManager();
        Task task = new Task(1, 2, TaskState.WAITING);
        manager.addTask(task);
        manager.releaseTask(1);
        assertEquals(TaskState.READY, manager.getTasks().get(1).getState());
    }

    // Test task preemption
    @Test
    public void testTaskPreemption() {
        TaskManager manager = new TaskManager();
        Task task = new Task(1, 2, TaskState.RUNNING);
        manager.addTask(task);
        manager.preemptTask(1);
        assertEquals(TaskState.READY, manager.getTasks().get(1).getState());
    }

    // Test task termination
    @Test
    public void testTaskTermination() {
        TaskManager manager = new TaskManager();
        Task task = new Task(1, 2, TaskState.RUNNING);
        manager.addTask(task);
        manager.terminateTask(1);
        assertEquals(TaskState.SUSPENDED, manager.getTasks().get(1).getState());
    }
}

