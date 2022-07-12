package pack;

import Classes.User;
import Classes.Task;
import java.util.Scanner;

import Repositories.TaskRepo;
import Repositories.UserRepo;

public class Main {
    public static void main(String[] args) {
        UserRepo.initialize();
        System.out.println("Hello! Welocme to the To Do App");
        System.out.println("Choose an option:");
        System.out.println("New User: n");
        System.out.println("Existing User: e");
        System.out.println("Type n or e depending on the option you want to choose");
        Scanner s = new Scanner(System.in);
        String a = s.nextLine();
        String g = "";
        User m = new User("", "");
        while(!g.equals("Stop"))
        {
            if (a.equals("n"))
            {
                String user;
                String pass;
                System.out.println("Type the desired username");
                user = s.nextLine();
                if(UserRepo.findUser(user) == -1)
                {
                    System.out.println("Type the desired password");
                    pass = s.nextLine();
                    User u = new User(user, pass);
                    UserRepo.addUser(u);
                    UserRepo.writeToFile();
                    System.out.println("Type n or e depending on the option you want to choose");
                }
                else
                {
                    System.out.println("User already exists!");
                    System.out.println("Type n or e depending on the option you want to choose");
                }
            }
            if (a.equals("e"))
            {
                String user;
                String pass;
                System.out.println("Username:");
                user = s.nextLine();
                int i = UserRepo.findUser((user));
                if(i != -1)
                {
                    System.out.println("Password:");
                    pass = s.nextLine();
                    if (UserRepo.users.get(i).getPass().equals(pass))
                    {
                        m = new User(user, pass);
                    }
                    g = "Stop";
                }
                else
                {
                    System.out.println("User already exists!");
                    System.out.println("Type n or e depending on the option you want to choose");
                }
            }
        }
        g = "";
        while (!g.equals("Stop"))
        {
            System.out.println("User: " + m.getName());
            System.out.println("Options:");
            System.out.println("1. Create a task");
            System.out.println("2. Show the list of tasks");
            System.out.println("3. Update a task");
            System.out.println("4. Update task status");
            System.out.println("5. Remove a users task");

            g = s.nextLine();

            if(g.equals("1"))
            {
                System.out.println("Task Name: ");
                String name = s.nextLine();
                System.out.println("Task Status: ");
                String status = s.nextLine();
                Task task = new Task(status, name);
                TaskRepo.addTask(task);
            }
            if(g.equals("2"))
            {
                TaskRepo.PrintTasks();
            }
        }
    }
}
