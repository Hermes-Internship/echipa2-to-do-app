package Repositories;

import Classes.Task;
import Classes.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class TaskRepo {
    public static ArrayList<Task> tasks;

    public TaskRepo()
    {
        this.readFromFile();
    }

    public static void addTask(Task t)
    {
        tasks.add(t);
    }

    private void readFromFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\Java\\echipa2-to-do-app\\Tasks.txt"));

            String st;
            while((st = br.readLine()) != null) {
                String[] el = st.split(",");
                if (el.length != 2) {
                    System.err.println("Not a valid number of attributes" + st);
                }
                else
                {
                    String status = el[0];
                    String name = el[1];
                    Task t = new Task(status, name);
                    tasks.add(t);
                }
            }
        } catch (IOException var8) {
            var8.printStackTrace();
        }
    }

    public static void writeToFile() {
        try {
            PrintWriter pw = new PrintWriter("D:\\Java\\echipa2-to-do-app\\Tasks.txt");

            try {
                for (Task elem : tasks)
                {
                    String line = elem.getStatus() + "," + elem.getName();
                    pw.println(line);
                }
            } catch (Throwable var5) {
                try {
                    pw.close();
                } catch (Throwable var4) {
                    var5.addSuppressed(var4);
                }

                throw var5;
            }
            pw.close();
        } catch (IOException var6) {
            var6.printStackTrace();
        }
    }

    public static void removeTask(Task t)
    {
        tasks.remove(t);
    }

    public static int findTask(String name)
    {
        for (Task elem : tasks)
            if(elem.getName().equals(name))
                return tasks.indexOf(elem);
        return -1;
    }

    public static void PrintTasks()
    {
        for (Task elem : tasks)
            System.out.println(elem.getName() + " " + elem.getStatus() + " " + elem.isAssigned());
    }
}
