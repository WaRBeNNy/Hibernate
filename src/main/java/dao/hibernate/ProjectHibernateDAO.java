package dao.hibernate;

import dao.EntityDAO;
import model.Entity;
import model.Project;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class ProjectHibernateDAO extends EntityDAO{
    Project project;

    @Override
    public void create(Entity entity) throws SQLException {
        project = (Project) entity;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(project);

        transaction.commit();
        session.close();

        System.out.println("Project " + project.getName() + " added to database.");
    }

    @Override
    public void read() throws SQLException{
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List projects = session.createQuery("FROM Project").list();
        for (Object project : projects) {
            System.out.println(project);
            System.out.println("\n================\n");
        }

        session.close();
    }

    @Override
    public void update(Entity entity) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        project = (Project) entity;
        Project upd = (Project) session.get(Project.class, project.getId());
        upd.setName(project.getName());
        upd.setCustomer_id(project.getCustomer_id());
        upd.setCompany_id(project.getCompany_id());
        upd.setCost(project.getCost());
        session.update(upd);

        transaction.commit();
        session.close();

        System.out.println("Project " + project.getName() + " succesfully updated");
    }

    @Override
    public void delete(int id) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        project = (Project) session.get(Project.class, id);
        session.delete(project);
        transaction.commit();
        session.close();

        System.out.println("Project " + project.getName() + " has been deleted");
    }

}
