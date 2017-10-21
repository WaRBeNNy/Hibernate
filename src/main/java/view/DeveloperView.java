package view;

import controller.JDBCController;
import model.Developer;

import java.sql.SQLException;
import java.util.Scanner;

public class DeveloperView implements EntityView {

    public void start() {
        Developer developer = new Developer();
        JDBCController controller = new JDBCController();
        controller.setDAO(developer);
        JDBCView view = new JDBCView();

        System.out.println("What should we do with developers?");
        System.out.println("1. Add new developer");
        System.out.println("2. Show all developers");
        System.out.println("3. Change a developers");
        System.out.println("4. Delete a developer");
        System.out.println("5. Back to main menu");

        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    developer = getDeveloper();
                    try {
                        controller.create(developer);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 2:
                    try {
                        controller.read();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 3:
                    developer = getDeveloper();
                    try {
                        controller.update(developer);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 4:
                    System.out.println("Enter id:");
                    try {
                        controller.delete(scanner.nextInt());
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 5:
                    try {
                        view.start();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("Wrong input!");
            }
        }
    }

    public Developer getDeveloper() {
        Developer developer = new Developer();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter id:");
        developer.setId(sc.nextInt());
        System.out.println("Enter name:");
        developer.setName(sc.next());
        System.out.println("Enter project id:");
        developer.setProject_id(sc.nextInt());
        System.out.println("Enter company id:");
        developer.setCompany_id(sc.nextInt());
        System.out.println("Enter salary:");
        developer.setSalary(sc.nextDouble());

        return developer;
    }
}
