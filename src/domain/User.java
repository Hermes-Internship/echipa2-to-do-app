package domain;

import java.util.ArrayList;
import java.util.Vector;

public class User {
    private String username;
    private String password;
    private Vector<Task> tasks;

    public User(String username, String password){
        this.username = username;
        this.password = password;
        tasks = new Vector<>();
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public Vector<Task> getTasks(){
        return tasks;
    }
}
