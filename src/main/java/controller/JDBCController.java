package controller;

import dao.EntityDAO;
import dao.FactoryDAO;
import model.Entity;

import java.sql.SQLException;

public class JDBCController {
    FactoryDAO factory = new FactoryDAO();
    EntityDAO eDAO = new EntityDAO();

    public void setDAO(Entity entity) {
        eDAO = factory.getDAO(entity);
    }

    public void create(Entity entity) throws SQLException, ClassNotFoundException {
        eDAO.connect();
        eDAO.create(entity);
        eDAO.close();
    }

    public void read() throws SQLException, ClassNotFoundException {
        eDAO.connect();
        eDAO.read();
        eDAO.close();
    }

    public void update(Entity entity) throws SQLException, ClassNotFoundException {
        eDAO.connect();
        eDAO.update(entity);
        eDAO.close();
    }

    public void delete(int id) throws SQLException, ClassNotFoundException {
        eDAO.connect();
        eDAO.delete(id);
        eDAO.close();
    }
}
