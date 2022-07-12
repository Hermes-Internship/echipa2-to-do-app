package domain;


/**
 * Domain class Task
 * <p>
 * TODO:
 * Find a better usage of enums, right now it's definitely not the best and, most likely, affects the rest of the CRUD operations in efficiency.
 * Add more details, maybe?
 */
public class Task {

    private String name;
    private Statuses status;

    public Task() {
    }

    public Task(String name, Statuses status) {
        this.name = name;
        this.status = status;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public Statuses getStatus() {
        return this.status;
    }

    public void setStatus(Statuses newStatus) {
        this.status = newStatus;
    }
}
