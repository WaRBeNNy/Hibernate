package dao.hibernate;

import dao.EntityDAO;
import model.Customer;
import model.Entity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class CustomerHibernateDAO extends EntityDAO{
    Customer customer;

    @Override
    public void create(Entity entity) throws SQLException {
        customer = (Customer) entity;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(customer);

        transaction.commit();
        session.close();

        System.out.println("Customer " + customer.getName() + " added to database.");
    }

    @Override
    public void read() throws SQLException{
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List customers = session.createQuery("FROM Customer ").list();
        for (Object cusomer : customers) {
            System.out.println(customer);
            System.out.println("\n================\n");
        }

        session.close();
    }

    @Override
    public void update(Entity entity) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        customer = (Customer) entity;
        Customer upd = (Customer) session.get(Customer.class, customer.getId());
        upd.setName(customer.getName());
        session.update(upd);

        transaction.commit();
        session.close();

        System.out.println("Customer " + customer.getName() + " succesfully updated");
    }

    @Override
    public void delete(int id) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        customer = (Customer) session.get(Customer.class, id);
        session.delete(customer);
        transaction.commit();
        session.close();

        System.out.println("Customer " + customer.getName() + " has been deleted");
    }

}
