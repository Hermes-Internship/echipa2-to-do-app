package repository;

import domain.Task;
import domain.User;

import java.util.Vector;

public class Repo {
    private Vector<User> users;

    public Repo(){
        this.users = new Vector<>();
    }

    public void addUser(User user){
        users.add(user);
    }

    public Vector<User> getAll(){
        return users;
    }

    public void createTask(int found, Task task){
        users.get(found).getTasks().add(task);
    }

    public void deleteTask(int found, Task task){
        users.get(found).getTasks().remove(task);
    }
}
