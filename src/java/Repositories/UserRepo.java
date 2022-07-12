package Repositories;

import Classes.User;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;


public class UserRepo {
    public static ArrayList<User> users = new ArrayList<>();

    public static void initialize()
    {
        UserRepo.readFromFile();
    }

    private static void readFromFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\Java\\echipa2-to-do-app\\User.txt"));

            String st;
            while((st = br.readLine()) != null) {
                String[] el = st.split(",");
                if (el.length != 2) {
                    System.err.println("Not a valid number of attributes" + st);
                }
                else
                {
                        String user = el[0];
                        String pass = el[1];
                        User u = new User(user, pass);
                        users.add(u);
                }
            }
        } catch (IOException var8) {
            var8.printStackTrace();
        }

    }

    public static void writeToFile() {
        try {
            PrintWriter pw = new PrintWriter("D:\\Java\\echipa2-to-do-app\\User.txt");

            try {
                for (User elem : users)
                {
                    String line = elem.getName() + "," + elem.getPass();
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

    public static void addUser(User u)
    {
        users.add(u);
    }

    public static int findUser(String name)
    {
        for (User elem : users)
            if(elem.getName().equals(name))
                return users.indexOf(elem);
        return -1;
    }

}
