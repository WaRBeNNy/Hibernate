package view;

import controller.JDBCController;
import model.Entity;

import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.System.exit;

public class JDBCView {
    JDBCController controller = new JDBCController();

    public void start() throws SQLException, ClassNotFoundException {
        System.out.println("Hello! Pick a table to operate with:");
        System.out.println("1. Companies");
        System.out.println("2. Customers");
        System.out.println("3. Developers");
        System.out.println("4. Projects");
        System.out.println("5. Skills");
        System.out.println("6. Exit");

        Scanner scanner = new Scanner(System.in);
        EntityView view;
        while(scanner.hasNext()) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    view = new CompanyView();
                    view.start();
                    break;
                case 2:
                    view = new CustomersView();
                    view.start();
                    break;
                case 3:
                    view = new DeveloperView();
                    view.start();
                    break;
                case 4:
                    view = new ProjectView();
                    view.start();
                    break;
                case 5:
                    view = new SkillView();
                    view.start();
                    break;
                case 6:
                    exit(0);
                    break;
                default:
                    System.out.println("Wrong input!");
            }
        }
    }
}
