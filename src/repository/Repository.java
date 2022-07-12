package repository;

import domain.Task;
import org.jetbrains.annotations.NotNull;

import java.util.Vector;


/**
 * Repository main class.
 * <p>
 * TODO:
 * <p>
 * Modify the write/read functions to do it in a database(file, SQL, JSON possibly)
 * <p>
 * Add more error handling, Validator methods.
 */
public class Repository {

    private final Vector<Task> userTasks = new Vector<>();

    public Repository() {
    }

    public void addTask(@NotNull Task task) throws Exception {
        if (findTaskByName(task.getName()) != -1) {
            throw new Exception("The task already exists.");
        }
        this.userTasks.add(task);
    }

    public void updateTask(@NotNull Task oldTask, @NotNull Task newTask) {
        this.userTasks.get(findTaskByName(oldTask.getName())).setName(newTask.getName());
        this.userTasks.get(findTaskByName(oldTask.getName())).setStatus(newTask.getStatus());
    }

    public void deleteTask(@NotNull Task task) throws Exception {
        if (findTaskByName(task.getName()) == -1)
            throw new Exception("The task does not exist.");
        this.userTasks.remove(task);
    }

    public Vector<Task> showTasks() {
        return this.userTasks;
    }

    public int findTaskByName(String name) {
        if (this.userTasks.size() == 0)
            return -1;
        for (int i = 0; i < this.userTasks.size(); i++) {
            if (this.userTasks.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

}
