package com.keita.second;

import java.util.HashMap;
import java.util.Map;

public class TaskManager {
    public Map<Integer, Task> getTasks() {
        return tasks;
    }

    private Map<Integer, Task> tasks; // Map to store tasks by task_id

    public TaskManager() {
        this.tasks = new HashMap<>();
    }

    public void addTask(Task task) {
        tasks.put(task.getTaskId(), task);
    }

    public void removeTask(int taskId) {
        tasks.remove(taskId);
    }

    public void activateTask(int taskId) {
        if (tasks.containsKey(taskId)) {
            tasks.get(taskId).setState(TaskState.READY);
        }
    }

    public void startTask(int taskId) {
        if (tasks.containsKey(taskId)) {
            tasks.get(taskId).setState(TaskState.RUNNING);
        }
    }

    public void waitTask(int taskId) {
        if (tasks.containsKey(taskId)) {
            tasks.get(taskId).setState(TaskState.WAITING);
        }
    }

    public void releaseTask(int taskId) {
        if (tasks.containsKey(taskId)) {
            tasks.get(taskId).setState(TaskState.READY);
        }
    }

    public void preemptTask(int taskId) {
        if (tasks.containsKey(taskId)) {
            tasks.get(taskId).setState(TaskState.READY);
        }
    }

    public void terminateTask(int taskId) {
        if (tasks.containsKey(taskId)) {
            tasks.get(taskId).setState(TaskState.SUSPENDED);
        }
    }
}
