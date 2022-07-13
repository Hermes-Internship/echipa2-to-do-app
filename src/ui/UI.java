package ui;

import domain.Task;
import domain.User;
import service.Service;

import java.util.Scanner;
import java.util.Vector;

public class UI {
    private Service srv;

    public UI(Service srv) {
        this.srv = srv;
    }

    private void createUser() {
        System.out.println("Enter username: ");
        Scanner scanner = new Scanner(System.in);
        String username;
        username = scanner.nextLine();

        System.out.println("Enter password: ");
        String password;
        password = scanner.nextLine();

        srv.addUser(username, password);

        System.out.println("User successfully created!");
    }

    private void printAll() {
        Vector<User> all = srv.getAll();
        for (User user : all) {
            System.out.println("Username: " + user.getUsername());
            System.out.println("Taskuri: ");
            for (Task task : user.getTasks()) {
                System.out.println(task.getTitle());
            }
        }
    }

    private void printMenuUser() {
        System.out.println("1. Sign up");
        System.out.println("2. Print users");
        System.out.println("3. Login");
        System.out.println("0. Exit");
    }


    private void startMenuTask(String username) {
        while (true) {
            System.out.println("1. Create task");
            System.out.println("2. Update task");
            System.out.println("3. Delete task");
            System.out.println("0. Exit");
            System.out.println("Enter command:");
            Scanner scanner = new Scanner(System.in);

            int command = -1;
            command = scanner.nextInt();
            scanner.nextLine();
            switch (command) {
                case 1:
                    System.out.println("Enter title: ");
                    String title;
                    title = scanner.nextLine();

                    System.out.println("Enter status: ");
                    String status;
                    status = scanner.nextLine();

                    srv.createTask(title, status, username);
                    break;
                case 2:
                    System.out.println("Enter title: ");
                    title = scanner.nextLine();

                    System.out.println("Enter new title: ");
                    String ntitle;
                    ntitle = scanner.nextLine();

                    System.out.println("Enter new or old status: ");
                    status = scanner.nextLine();

                    srv.updateTask(title,ntitle,status,username);
                    break;
                case 3:
                    System.out.println("Enter title: ");
                    title = scanner.nextLine();

                    srv.deleteTask(username, title);
                    break;
                case 0:
                    return;
            }
        }
    }

    public void start() {
        while (true) {
            printMenuUser();
            int option = -1;
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    createUser();
                    break;
                case 2:
                    printAll();
                    break;
                case 3:
                    System.out.println("Enter username: ");
                    String username;
                    username = scanner.nextLine();

                    startMenuTask(username);
                    break;
                case 0:
                    return;
            }
        }
    }
}
