package dao;

import model.Entity;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EntityDAO {
    static final String DATABASE_URL = "jdbc:mysql://localhost/my_schema";

    static final String USER = "root";
    static final String PASSWORD = "BeNNySQL007";

    Connection connection = null;
    Statement statement = null;

    protected static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        connection = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);

        statement = connection.createStatement();
    }

    public void create(Entity entity) throws  SQLException{
    }

    public void read() throws SQLException{

    }

    public void update(Entity entity) throws SQLException {

    }

    public void delete(int id) throws SQLException {

    }

    public void close() throws SQLException {
        statement.close();
        connection.close();
    }
}
