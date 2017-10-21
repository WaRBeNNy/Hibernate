package dao;

import model.Company;
import model.Entity;

import java.sql.*;

public class CompanyDAO extends EntityDAO {
    Company company;

    @Override
    public void create(Entity entity) throws SQLException {
        company = (Company) entity;
        String sql = "INSERT INTO `my_schema`.`companies` VALUES ('" + company.getId() + "', '" + company.getName() + "')";

        statement.execute(sql);
        System.out.println("Company " + company.getName() + " added to database.");
    }

    @Override
    public void read() throws SQLException {
        String sql;
        sql = "SELECT * FROM `my_schema`.`companies`";

        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println("Retrieving data from database...");
        System.out.println("\nCompanies:");
        while (resultSet.next()) {
            company = new Company(resultSet.getInt("comp_id"), resultSet.getString("name"));

            System.out.println("\n================\n");
            System.out.println("id: " + company.getId());
            System.out.println("Name: " + company.getName());
        }
        resultSet.close();
    }

    @Override
    public void update(Entity entity) throws SQLException {
        company = (Company) entity;
        String sql = "UPDATE `my_schema`.`companies` SET `name`='" + company.getName() + "' WHERE `comp_id`='" + company.getId() + "'";

        statement.execute(sql);
        System.out.println("Company " + company.getName() + " has been updated");
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM `my_schema`.`companies` WHERE `comp_id`='" + id + "';";

        statement.execute(sql);
        System.out.println("Company with id=" + id + " has been deleted.");
    }

}
