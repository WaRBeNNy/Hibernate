package view;

import controller.JDBCController;
import model.Project;

import java.sql.SQLException;
import java.util.Scanner;

public class ProjectView implements EntityView{

        public void start() {
            Project project = new Project();
            JDBCController controller = new JDBCController();
            controller.setDAO(project);
            JDBCView view = new JDBCView();

            System.out.println("What should we do with projects?");
            System.out.println("1. Add new project");
            System.out.println("2. Show all projectss");
            System.out.println("3. Change a project");
            System.out.println("4. Delete a project");
            System.out.println("5. Back to main menu");

            Scanner scanner = new Scanner(System.in);

            while(scanner.hasNext()) {
                int choice = scanner.nextInt();
                switch (choice) {
                    case 1:
                        project = getProject();
                        try {
                            controller.create(project);
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
                        project = getProject();
                        try {
                            controller.update(project);
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

    public Project getProject() {
        Project project = new Project();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter id:");
        project.setId(sc.nextInt());
        System.out.println("Enter name:");
        project.setName(sc.next());
        System.out.println("Enter company id:");
        project.setCompany_id(sc.nextInt());
        System.out.println("Enter customer id:");
        project.setCustomer_id(sc.nextInt());
        System.out.println("Enter cost:");
        project.setCost(sc.nextDouble());

        return project;
    }


}
