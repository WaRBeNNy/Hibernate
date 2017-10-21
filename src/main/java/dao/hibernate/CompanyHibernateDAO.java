package dao.hibernate;

import dao.EntityDAO;
import model.Company;
import model.Entity;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class CompanyHibernateDAO extends EntityDAO {
    Company company;

    @Override
    public void create(Entity entity) throws SQLException{
        company = (Company) entity;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(company);

        transaction.commit();
        session.close();

        System.out.println("Company " + company.getName() + " added to database.");
    }

    @Override
    public void read() throws SQLException{
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List companies = session.createQuery("FROM Company").list();
        for (Object company : companies) {
            System.out.println(company);
            System.out.println("\n================\n");
        }

        session.close();
    }

    @Override
    public void update(Entity entity) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        company = (Company) entity;
        Company upd = (Company) session.get(Company.class, company.getId());
        upd.setName(company.getName());
        session.update(upd);

        transaction.commit();
        session.close();
    }

    @Override
    public void delete(int id) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        company = (Company) session.get(Company.class, id);
        session.delete(company);
        transaction.commit();
        session.close();
    }

}
