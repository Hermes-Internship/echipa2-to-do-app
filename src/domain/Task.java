package domain;

public class Task {
    private String title;
    private String status;

    public Task(String title, String status){
        this.title = title;
        this.status = status;
    }

    //getters
    public String getTitle(){
        return title;
    }

    public String getStatus(){
        return status;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setStatus(String status){
        this.status = status;
    }
}
