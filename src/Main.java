import repository.Repository;
import service.Service;
import ui.Ui;

public class Main {
    public static void main(String[] args) throws Exception {
        Repository repo = new Repository();
        Service serv = new Service(repo);

        Ui ui = new Ui(serv);

        ui.startUI();
    }
}
