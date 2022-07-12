package domain;


/**
 * Domain class Customer
 * <p>
 * TODO:
 * Find out exactly what parameters does the Customer want, for now there is just an ID and a user Task, but they are not used.
 * I'm not sure that we have to use this class, but in any case, here it is.
 */
public class Customer {

    private int userID;
    private Task userTask;

    public Customer() {
    }

    public Customer(int userID, Task task) {
        this.userID = userID;
        this.userTask = task;
    }

    public int getUserID() {
        return this.userID;
    }

    public void setUserID(int newID) {
        this.userID = newID;
    }

    public Task getUserTask() {
        return this.userTask;
    }

    public void setUserTask(Task newTask) {
        this.userTask = newTask;
    }

}
