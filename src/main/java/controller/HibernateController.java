package controller;

import model.Entity;

import java.sql.SQLException;

public class HibernateController extends JDBCController {
    @Override
    public void create(Entity entity) throws SQLException, ClassNotFoundException {
        eDAO.create(entity);
    }

    @Override
    public void read() throws SQLException, ClassNotFoundException {
        eDAO.read();
    }

    @Override
    public void update(Entity entity) throws SQLException, ClassNotFoundException {
        eDAO.update(entity);
    }

    @Override
    public void delete(int id) throws SQLException, ClassNotFoundException {
        eDAO.delete(id);
    }
}
