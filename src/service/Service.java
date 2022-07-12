package service;


import domain.Statuses;
import domain.Task;
import repository.Repository;

import java.util.Vector;

public class Service {

    private Repository repo;

    public Service(Repository repo) {
        this.repo = repo;
    }

    public void addTask(String name, Statuses status) throws Exception {
        Task task = new Task(name, status);
        this.repo.addTask(task);
    }

    public void updateTask(String oldName, String newName, Statuses newStatus) throws Exception {
        Task oldTask = findTask(oldName);
        Task newTask = new Task(newName, newStatus);
        this.repo.updateTask(oldTask, newTask);
    }

    public void deleteTask(String name) throws Exception {
        Task task = findTask(name);
        if (task != null) {
            this.repo.deleteTask(task);
        }
    }

    public Vector<Task> showTasks() {
        return this.repo.showTasks();
    }

    public Task findTask(String name) throws Exception {
        for (Task task : showTasks()) {
            if (task.getName().equals(name))
                return task;
        }
        throw new Exception("Task not found");
    }
}
