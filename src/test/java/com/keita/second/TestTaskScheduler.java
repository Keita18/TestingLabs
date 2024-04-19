package com.keita.second;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TestTaskScheduler {
    @Test
    public void testAddReadyTaskWithSpace() {
        TaskScheduler scheduler = new TaskScheduler(3);
        Task task1 = new Task(1, 2, TaskState.READY);
        scheduler.addReadyTask(task1);
        assertEquals(task1, scheduler.getAndRemoveNextTask());
    }

    @Test
    public void testGetAndRemoveNextTask() {
        TaskScheduler scheduler = new TaskScheduler(3);
        Task task1 = new Task(1, 2, TaskState.READY);
        Task task2 = new Task(2, 1, TaskState.READY);
        Task task3 = new Task(3, 3, TaskState.READY);
        scheduler.addReadyTask(task1);
        scheduler.addReadyTask(task2);
        scheduler.addReadyTask(task3);

        assertEquals(task2, scheduler.getAndRemoveNextTask());
        assertEquals(task1, scheduler.getAndRemoveNextTask());
        assertEquals(task3, scheduler.getAndRemoveNextTask());
        assertNull(scheduler.getAndRemoveNextTask());
    }

    @Test
    public void testTaskScheduling() {
        TaskScheduler scheduler = new TaskScheduler(3);

        Task task1 = new Task(1, 2, "READY");
        Task task2 = new Task(2, 1, "READY");
        Task task3 = new Task(3, 3, "READY");
        Task task4 = new Task(4, 0, "READY");
        Task task5 = new Task(5, 2, "READY"); // Same priority as task1

        task1.setScheduler(scheduler);
        task2.setScheduler(scheduler);
        task3.setScheduler(scheduler);
        task4.setScheduler(scheduler);
        task5.setScheduler(scheduler);

        scheduler.addReadyTask(task1);
        scheduler.addReadyTask(task2);
        scheduler.addReadyTask(task3);

        scheduler.addReadyTask(task4);
        assertEquals(4, scheduler.getAndRemoveNextTask().getTaskId()); // Task 4 should be removed first

        scheduler.addReadyTask(task5);
        assertEquals(1, scheduler.getAndRemoveNextTask().getTaskId()); // Task 4 should be removed next

        Task task6 = new Task(6, 0, "READY");
        Task task7 = new Task(7, 3, "READY");
        Task task8 = new Task(8, 2, "READY");
        task6.setScheduler(scheduler);
        task7.setScheduler(scheduler);
        task8.setScheduler(scheduler);
        scheduler.addReadyTask(task6);
        scheduler.addReadyTask(task7);
        scheduler.addReadyTask(task8);

        assertEquals(8, scheduler.getAndRemoveNextTask().getTaskId());
        assertEquals(7, scheduler.getAndRemoveNextTask().getTaskId());

        assertEquals(3, scheduler.getAndRemoveNextTask().getTaskId());
        assertNull(scheduler.getAndRemoveNextTask());
    }
}
