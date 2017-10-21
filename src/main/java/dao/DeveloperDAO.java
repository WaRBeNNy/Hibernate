package dao;

import model.Developer;
import model.Entity;

import java.sql.*;

public class DeveloperDAO extends EntityDAO{
    Developer developer;

    @Override
    public void create(Entity entity) throws SQLException {
        developer = (Developer) entity;
        String sql = "INSERT INTO `my_schema`.`developers` VALUES ('" + developer.getId() + "', '"
                + developer.getName() + "', '" + developer.getProject_id() + "', '" + developer.getCompany_id()
                + "', '" + developer.getSalary() + "')";

        statement.execute(sql);
        System.out.println("Developer " + developer.getName() + " added to database.");
    }

    @Override
    public void read() throws SQLException {
        String sql;
        sql = "SELECT * FROM `my_schema`.`developers`";

        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println("Retrieving data from database...");
        System.out.println("\nDevelopers:");
        while (resultSet.next()) {
            developer = new Developer(resultSet.getInt("dev_id"), resultSet.getString("name"), resultSet.getInt("project_id"), resultSet.getInt("comp_id"), resultSet.getDouble("salary"));

            System.out.println("\n================\n");
            System.out.println("id: " + developer.getId());
            System.out.println("Name: " + developer.getName());
            System.out.println("Project id=" + developer.getProject_id());
            System.out.println("Company id=" + developer.getCompany_id());
            System.out.println("Salary: " + developer.getSalary());
        }
        resultSet.close();
    }

    @Override
    public void update(Entity entity) throws SQLException {
        developer = (Developer) entity;
        String sql = "UPDATE `my_schema`.`developers` SET `name`='" + developer.getName() +
                ", `project_id`=`" + developer.getProject_id() +
                ", `comp_id`=`" + developer.getCompany_id() +
                ", `salary`=`" + developer.getSalary() + " WHERE `dev_id`='" + developer.getId() + "'";

        statement.execute(sql);
        System.out.println("Developer " + developer.getName() + " has been updated");
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM `my_schema`.`developers` WHERE `dev_id`='" + id + "';";

        statement.execute(sql);
        System.out.println("Developer with id=" + id + " has been deleted.");
    }

}
