package Classes;

public class Task {

    private String status;
    private String name;
    private boolean assigned;

    public Task()
    {
        this.name = "";
        this.status = "New";
        this.assigned = false;
    }

    public Task(String status, String name)
    {
        this.name = name;
        if(status.equals("New") || status.equals("In_Progress") || status.equals("Done"))
            this.status = status;
        else
            this.status = "New";
    }

    public String getStatus()
    {
        return this.status;
    }

    public void setStatus(String s)
    {
        if(status.equals("New") || status.equals("In_Progress") || status.equals("Done"))
            this.status = s;
    }

    public void printStatus()
    {
        System.out.println(this.status);;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String n)
    {
        this.name = n;
    }

    public void printName()
    {
        System.out.println(this.name);;
    }

    public boolean isAssigned() {
        return assigned;
    }

    public void setAssigned(boolean a)
    {
        this.assigned = a;
    }
}
