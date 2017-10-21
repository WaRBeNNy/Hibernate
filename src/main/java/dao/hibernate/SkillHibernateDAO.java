package dao.hibernate;

import dao.EntityDAO;
import model.Entity;
import model.Skill;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class SkillHibernateDAO extends EntityDAO{
    Skill skill;

    @Override
    public void create(Entity entity) throws SQLException {
        skill = (Skill) entity;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.save(skill);

        transaction.commit();
        session.close();

        System.out.println("Skill " + skill.getName() + " added to database.");
    }

    @Override
    public void read() throws SQLException{
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        List skills = session.createQuery("FROM Skill").list();
        for (Object skill : skills) {
            System.out.println(skill);
            System.out.println("\n================\n");
        }

        session.close();
    }

    @Override
    public void update(Entity entity) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        skill = (Skill) entity;
        Skill upd = (Skill) session.get(Skill.class, skill.getId());
        upd.setName(skill.getName());
        upd.setDeveloper_id(skill.getDeveloper_id());
        session.update(upd);

        transaction.commit();
        session.close();

        System.out.println("Skill " + skill.getName() + " succesfully updated");
    }

    @Override
    public void delete(int id) throws SQLException {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        skill = (Skill) session.get(Skill.class, id);
        session.delete(skill);
        transaction.commit();
        session.close();

        System.out.println("Skill " + skill.getName() + " has been deleted");
    }

}
