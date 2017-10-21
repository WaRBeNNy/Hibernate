package dao;

import dao.hibernate.*;
import model.*;

public class FactoryDAO {
    public EntityDAO getDAO(Object object) {
        EntityDAO eDAO = null;
        if(object instanceof Company)
            eDAO = new CompanyHibernateDAO();
        else if(object instanceof Customer)
            eDAO = new CustomerHibernateDAO();
        else if(object instanceof Developer)
            eDAO = new DeveloperHibernateDAO();
        else if(object instanceof Project)
            eDAO = new ProjectHibernateDAO();
        else if(object instanceof Skill)
            eDAO = new SkillHibernateDAO();

        return eDAO;
    }
}
