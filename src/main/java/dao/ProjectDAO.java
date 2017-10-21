package dao;

import model.Entity;
import model.Project;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProjectDAO extends EntityDAO{
    Project project;

    @Override
    public void create(Entity entity) throws SQLException {
        project = (Project) entity;
        String sql = "INSERT INTO `my_schema`.`projects` VALUES ('" + project.getId() + "', '"
                + project.getName() + "', '" + project.getCompany_id() + "', '" + project.getCustomer_id()
                + "', '" + project.getCost() + "')";

        statement.execute(sql);
        System.out.println("Developer " + project.getName() + " added to database.");
    }

    @Override
    public void read() throws SQLException {
        String sql;
        sql = "SELECT * FROM `my_schema`.`projects`";

        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println("Retrieving data from database...");
        System.out.println("\nProjects:");
        while (resultSet.next()) {
            project = new Project(resultSet.getInt("project_id"), resultSet.getString("projectname"),
                    resultSet.getInt("comp_id"), resultSet.getInt("customer_id"),
                    resultSet.getDouble("cost"));

            System.out.println("\n================\n");
            System.out.println("id: " + project.getId());
            System.out.println("Name: " + project.getName());
            System.out.println("Company id=" + project.getCompany_id());
            System.out.println("Customer id=" + project.getCustomer_id());
            System.out.println("Cost: " + project.getCost());
        }
        resultSet.close();
    }

    @Override
    public void update(Entity entity) throws SQLException {
        project = (Project) entity;
        String sql = "UPDATE `my_schema`.`projects` SET `name`='" + project.getName() +
                ", `comp_id`=`" + project.getCompany_id() +
                ", `customer_id`=`" + project.getCustomer_id() +
                ", `cost`=`" + project.getCost() + " WHERE `project_id`='" + project.getId() + "'";

        statement.execute(sql);
        System.out.println("Project " + project.getName() + " has been updated");
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM `my_schema`.`projects` WHERE `project_id`='" + id + "';";

        statement.execute(sql);
        System.out.println("Project with id=" + id + " has been deleted.");
    }

}
