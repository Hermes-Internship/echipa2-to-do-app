package service;

import domain.Task;
import domain.User;
import repository.Repo;

import java.util.Vector;

public class Service {
    private Repo repo;

    public Service(Repo repo){
        this.repo = repo;
    }

    public void addUser(String username, String password){
        User user = new User(username, password);
        repo.addUser(user);
    }

    public Vector<User> getAll(){
        return repo.getAll();
    }

    public void createTask(String title, String status, String username){
        int found = findUser(username);
        if(found != -1) {
            Task task = new Task(title, status);
            repo.createTask(found, task);
        }
    }

    public void updateTask(String title,String new_title, String new_status, String username){
        int found = findUser(username);
        if(found != -1) {
            Vector<User> users = repo.getAll();
            findTask(users.get(found),title,new_title,new_status);
        }
    }

    public void findTask(User user,String name,String new_name,String new_status){
        for(Task task: user.getTasks()){
            if(task.getTitle().equals(name))
                task.setTitle(new_name);
                task.setStatus(new_status);
        }
    }

    public void deleteTask(String username, String title){
        int found = findUser(username);
        int index = findTaskIndex(found, title);
        repo.deleteTask(found, repo.getAll().get(found).getTasks().get(index));
    }
    public int findUser(String username){
        Vector<User> users = repo.getAll();
        for(int i=0; i<users.size(); i++){
            if(users.get(i).getUsername().equals(username)){
                return i;
            }
        }
        return -1;
    }

    public int findTaskIndex(int foundUser, String title){
        Vector<Task> tasks = repo.getAll().get(foundUser).getTasks();
        for(int i = 0; i < tasks.size(); i++)
            if(tasks.get(i).getTitle().equals(title)){
                return i;
            }
        return -1;
    }
}
