package com.keita.second;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TaskScheduler {
    private final int maxReadyTasks;
    private final List<Task> readyTasks;

    public TaskScheduler(int maxReadyTasks) {
        this.maxReadyTasks = maxReadyTasks;
        this.readyTasks = new ArrayList<>();
    }

    public void addReadyTask(Task task) {

        if (readyTasks.size() < maxReadyTasks) {
            readyTasks.add(task);
            int insertionOrder = readyTasks.size();
            task.setInsertionOrder(insertionOrder);
            readyTasks.sort(Comparator.comparing(Task::getPriority)
                    .thenComparingInt(readyTasks::indexOf));
            printTasks("After adding task: " + task.getTaskId());
        } else {
            int lowestPriorityIndex = getLowestPriorityIndex();
            if (lowestPriorityIndex != -1) {
                readyTasks.set(lowestPriorityIndex, task);
                readyTasks.sort(Comparator.comparing(Task::getPriority)
                        .thenComparingInt(readyTasks::indexOf));
                printTasks("After adding task: " + task.getTaskId());
            }
        }
    }


    private void printTasks(String message) {
        System.out.println(message);
        for (Task task : readyTasks) {
            System.out.println("Task ID: " + task.getTaskId() + ", Priority: " + task.getPriority());
        }
        System.out.println("---");
    }


    public Task getAndRemoveNextTask() {
        if (!readyTasks.isEmpty()) {
            Task nextTask = null;
            int lowestPriority = Integer.MAX_VALUE;
            int lowestInsertionOrder = -1;

            for (Task task : readyTasks) {
                if (task.getPriority() < lowestPriority || (task.getPriority() == lowestPriority && task.getInsertionOrder() < lowestInsertionOrder)) {
                    lowestPriority = task.getPriority();
                    lowestInsertionOrder = task.getInsertionOrder();
                    nextTask = task;
                }
            }

            readyTasks.remove(nextTask);
            return nextTask;
        } else {
            return null;
        }
    }

    private int getLowestPriorityIndex() {
        int lowestPriority = Integer.MAX_VALUE;
        int lowestPriorityIndex = -1;
        for (int i = 0; i < readyTasks.size(); i++) {
            if (readyTasks.get(i).getPriority() < lowestPriority) {
                lowestPriority = readyTasks.get(i).getPriority();
                lowestPriorityIndex = i;
            }
        }
        return lowestPriorityIndex;
    }
}
