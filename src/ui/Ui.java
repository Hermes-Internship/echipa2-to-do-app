package ui;

import domain.Statuses;
import domain.Task;
import service.Service;

import java.util.Scanner;
import java.util.Vector;

public class Ui {

    private Service serv;

    public Ui() {
    }

    public Ui(Service serv) {
        this.serv = serv;
    }

    public void printMenu() {
        System.out.println("Choose an option from the menu");
        System.out.println("1. Add a new task.");
        System.out.println("2. Update task details.");
        System.out.println("3. Delete a task.");
        System.out.println("4. Show all the tasks.");
        System.out.println("0. Exit the program.");
    }

    /**
     * Start UI method
     * <p>
     * <p>
     * TODO:
     * <p>
     * Find a better way to read the input(can be done by reading strings and recasting, but for now it does work like this as well.
     * <p>
     * Maybe modify all the try catch blocks to have UI functions for the CRUD operations, not to call them directly from the service.
     * Case 1, add, fix the statusName switch
     * <p>
     * Add some more error handling ways, possibly a Validator class.
     * <p>
     * workaround for the nextLine() read after nextInt() bug, source:
     * <a href="https://stackoverflow.com/questions/13102045/scanner-is-skipping-nextline-after-using-next-or-nextfoo">...</a>
     */
    public void startUI() throws Exception {
        Scanner reader = new Scanner(System.in);
        int option = -1;
        {
            while (true) {
                printMenu();
                option = reader.nextInt();
                reader.nextLine();
                switch (option) {
                    case 0:
                        return;
                    case 1: {
                        String name;
                        Statuses status = null;
                        String statusName;
                        System.out.println("Enter the name of the task:");
                        name = reader.nextLine();
                        System.out.println("Select one of the statuses (NEW, IN PROGRESS, DONE):");
                        statusName = reader.nextLine();
                        switch (statusName) {
                            case "NEW":
                                status = Statuses.NEW;
                                break;
                            case "IN PROGRESS":
                                status = Statuses.IN_PROGRESS;
                                break;
                            case "DONE":
                                status = Statuses.DONE;
                                break;
                        }
                        try {
                            this.serv.addTask(name, status);
                            System.out.println("Success!");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                    }
                    break;
                    case 2: {
                        String name;
                        String newName;
                        Statuses status = null;
                        String statusName;
                        System.out.println("Enter the name of the current task:");
                        name = reader.nextLine();
                        System.out.println("Enter the new name of the task and one of the statuses (NEW, IN PROGRESS, DONE):");
                        newName = reader.nextLine();
                        statusName = reader.nextLine();
                        switch (statusName) {
                            case "NEW":
                                status = Statuses.NEW;
                                break;
                            case "IN PROGRESS":
                                status = Statuses.IN_PROGRESS;
                                break;
                            case "DONE":
                                status = Statuses.DONE;
                                break;
                        }
                        try {
                            this.serv.updateTask(name, newName, status);
                            System.out.println("Success!");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                    case 3: {
                        String name;
                        System.out.println("Enter the name of the task that you want to delete:");
                        name = reader.nextLine();
                        try {
                            this.serv.deleteTask(name);
                            System.out.println("Success!");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                    case 4: {
                        Vector<Task> tasks = this.serv.showTasks();
                        if (tasks.size() == 0) {
                            System.out.println("No task for now.");
                        } else {
                            for (Task task : tasks) {
                                System.out.println("Task name: " + task.getName() + " | Status: " + task.getStatus());
                            }
                        }
                    }
                    break;
                    default:
                        break;

                }
            }
        }
    }
}
