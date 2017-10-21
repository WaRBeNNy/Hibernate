package view;

import controller.JDBCController;
import model.Skill;

import java.sql.SQLException;
import java.util.Scanner;

public class SkillView implements EntityView {

     public void start() {
        Skill skill = new Skill();
        JDBCController controller = new JDBCController();
        controller.setDAO(skill);
        JDBCView view = new JDBCView();

        System.out.println("What should we do with skills?");
        System.out.println("1. Add new skill");
        System.out.println("2. Show all skills");
        System.out.println("3. Change a skill");
        System.out.println("4. Delete a skill");
        System.out.println("5. Back to main menu");

        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()) {
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    skill = getSkill();
                    try {
                        controller.create(skill);
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
                    skill = getSkill();
                    try {
                        controller.update(skill);
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

    public Skill getSkill() {
        Skill skill = new Skill();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter id:");
        skill.setId(sc.nextInt());
        System.out.println("Enter name:");
        skill.setName(sc.next());
        System.out.println("Enter developer id:");
        skill.setDeveloper_id(sc.nextInt());

        return skill;
    }
}
