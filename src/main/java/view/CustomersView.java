package view;

import controller.JDBCController;
import model.Customer;

import java.sql.SQLException;
import java.util.Scanner;

public class CustomersView implements EntityView{

    public void start() {
        Customer customer = new Customer();
        JDBCController controller = new JDBCController();
        controller.setDAO(customer);
        JDBCView view = new JDBCView();

        System.out.println("What should we do with customers?");
        System.out.println("1. Add new customer");
        System.out.println("2. Show all customers");
        System.out.println("3. Change a customer");
        System.out.println("4. Delete a customer");
        System.out.println("5. Back to main menu");

        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    customer = getCustomer();
                    try {
                        controller.create(customer);
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
                    customer = getCustomer();
                    try {
                        controller.update(customer);
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

    public Customer getCustomer() {
        Customer customer = new Customer();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter id:");
        customer.setId(sc.nextInt());
        System.out.println("Enter name:");
        customer.setName(sc.next());

        return customer;
    }
}
