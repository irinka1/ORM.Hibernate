package hibernate.cachetest.Storages;

import hibernate.cachetest.Entities.Developer;
import hibernate.cachetest.Entities.Skills;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class SkillsStorage {
    private SessionFactory sessionFactory;

    public SkillsStorage() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public Skills createSkills(Skills skills){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(skills);
        transaction.commit();
        session.close();
        return skills;
    }

    public void deleteSkills(Skills cat){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(cat);
        transaction.commit();
        session.close();
    }

    public List<Skills> listSkills(){ //read cat
        Session session = sessionFactory.openSession();
        List<Skills> skills = session.createQuery("from Skills").list();
        session.close();
        return skills;
    }

    public void updateSkills(Skills skills){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(skills);
        transaction.commit();
        session.close();

    }
}
