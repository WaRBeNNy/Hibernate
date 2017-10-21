package view;

import controller.JDBCController;
import model.Company;

import java.sql.SQLException;
import java.util.Scanner;

public class CompanyView implements EntityView{

    public void start() {
        Company company = new Company();
        JDBCController controller = new JDBCController();
        controller.setDAO(company);
        JDBCView view = new JDBCView();

        System.out.println("What should we do with companies?");
        System.out.println("1. Add new company");
        System.out.println("2. Show all companies");
        System.out.println("3. Change a company");
        System.out.println("4. Delete a company");
        System.out.println("5. Back to main menu");

        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    company = getCompany();
                    try {
                        controller.create(company);
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
                    company = getCompany();
                    try {
                        controller.update(company);
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

    public Company getCompany() {
        Company company = new Company();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter id:");
        company.setId(sc.nextInt());
        System.out.println("Enter name:");
        company.setName(sc.next());

        return company;
    }
}
