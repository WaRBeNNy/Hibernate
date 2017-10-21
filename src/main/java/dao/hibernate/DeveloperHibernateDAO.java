package dao.hibernate;

import dao.EntityDAO;
import model.Developer;
import model.Entity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class DeveloperHibernateDAO extends EntityDAO{
    Developer developer;

    @Override
    public void create(Entity entity) throws SQLException {
        developer = (Developer) entity;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(developer);

        transaction.commit();
        session.close();

        System.out.println("Developer " + developer.getName() + " added to database.");
    }

    @Override
    public void read() throws SQLException{
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List developers = session.createQuery("FROM Developer").list();
        for (Object developer : developers) {
            System.out.println(developer);
            System.out.println("\n================\n");
        }

        session.close();
    }

    @Override
    public void update(Entity entity) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        developer = (Developer) entity;
        Developer upd = (Developer) session.get(Developer.class, developer.getId());
        upd.setName(developer.getName());
        upd.setProject_id(developer.getProject_id());
        upd.setCompany_id(developer.getCompany_id());
        upd.setSalary(developer.getSalary());
        session.update(upd);

        transaction.commit();
        session.close();

        System.out.println("Developer " + developer.getName() + " succesfully updated");
    }

    @Override
    public void delete(int id) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        developer = (Developer) session.get(Developer.class, id);
        session.delete(developer);
        transaction.commit();
        session.close();

        System.out.println("Developer " + developer.getName() + " has been deleted");
    }

}
