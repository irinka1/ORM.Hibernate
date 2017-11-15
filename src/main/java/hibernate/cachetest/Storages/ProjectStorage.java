package hibernate.cachetest.Storages;

import hibernate.cachetest.Entities.Developer;
import hibernate.cachetest.Entities.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ProjectStorage {

    private SessionFactory sessionFactory;



    public ProjectStorage() {
        sessionFactory = new Configuration().configure().buildSessionFactory();

    }

    public Project createProject(Project project){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(project);
        transaction.commit();
        session.close();
        return project;
    }

    public void deleteProject(Project project){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(project);
        transaction.commit();
        session.close();
    }

    public List<Project> listProject(){
        Session session = sessionFactory.openSession();
        List<Project> project = session.createQuery("from Project").list();
        session.close();
        return project;
    }

    public void updateProject(Project project){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(project);
        transaction.commit();
        session.close();

    }
}
