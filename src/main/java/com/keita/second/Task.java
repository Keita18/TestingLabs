package com.keita.second;

import java.util.Objects;

public class Task {
    private int taskId;
    private int priority;
    private String state;

    private int insertionOrder;


    private TaskScheduler scheduler;


    public Task(int taskId, int priority, String state) {
        this.taskId = taskId;
        this.priority = priority;
        this.state = state;
    }

    // Getters and setters
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setScheduler(TaskScheduler scheduler) {
        this.scheduler = scheduler;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Task)) return false;
        Task task = (Task) o;
        return taskId == task.taskId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(taskId);
    }

    public int getInsertionOrder() {
        return insertionOrder;
    }

    public void setInsertionOrder(int insertionOrder) {
        this.insertionOrder = insertionOrder;
    }
}
