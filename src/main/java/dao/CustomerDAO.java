package dao;

import model.Customer;
import model.Entity;

import java.sql.*;

public class CustomerDAO extends EntityDAO{
    Customer customer;

    @Override
    public void create(Entity entity) throws SQLException {
        customer = (Customer) entity;
        String sql = "INSERT INTO `my_schema`.`customers` VALUES ('" + customer.getId() + "', '" + customer.getName() + "')";

        statement.execute(sql);
        System.out.println("Customer " + customer.getName() + " added to database.");
    }

    @Override
    public void read() throws SQLException {
        String sql;
        sql = "SELECT * FROM `my_schema`.`customers`";

        ResultSet resultSet = statement.executeQuery(sql);

        System.out.println("Retrieving data from database...");
        System.out.println("\nCustomers:");
        while (resultSet.next()) {
            customer = new Customer(resultSet.getInt("customer_id"), resultSet.getString("name"));

            System.out.println("\n================\n");
            System.out.println("id: " + customer.getId());
            System.out.println("Name: " + customer.getName());
        }
        resultSet.close();
    }

    @Override
    public void update(Entity entity) throws SQLException {
        customer = (Customer) entity;
        String sql = "UPDATE `my_schema`.`customers` SET `name`='" + customer.getName() + "' WHERE `customer_id`='" + customer.getId() + "'";

        statement.execute(sql);
        System.out.println("Customer " + customer.getName() + " has been updated");
    }

    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM `my_schema`.`customers` WHERE `customer_id`='" + id + "';";

        statement.execute(sql);
        System.out.println("Customer with id=" + id + " has been deleted.");
    }

}
