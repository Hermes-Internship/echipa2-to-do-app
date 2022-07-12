package Classes;

import Repositories.TaskRepo;

public class User {
    private String username;
    private String password;
    private Task assignedTask;

    public User (String u, String p)
    {
        this.assignedTask = null;
        this.username = u;
        this.password = p;
    }

    public void assignTask(Task task)
    {
            this.assignedTask = task;
            task.setAssigned(true);
    }

    public void unassignTask()
    {
        if(this.assignedTask != null)
        {
            this.assignedTask.setAssigned(false);
            this.assignedTask = null;
        }
    }

    public void createTask(String status, String nume)
    {
        Task a = new Task(status, nume);
        TaskRepo.addTask(a);
    }

    public String getName()
    {
        return this.username;
    }

    public String getPass()
    {
        return this.password;
    }

    public String getTask()
    {
        return this.assignedTask.getName();
    }
}
