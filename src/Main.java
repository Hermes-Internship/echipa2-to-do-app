import repository.Repo;
import service.Service;
import ui.UI;

public class Main {
    public static void main(String[] args) {
        Repo repo = new Repo();
        Service service = new Service(repo);
        UI ui = new UI(service);
        ui.start();
    }
}
