package hibernate.cachetest.Storages;

import hibernate.cachetest.DAOs.CompaniesDao;
import hibernate.cachetest.Entities.Companies;
import hibernate.cachetest.Entities.Developer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CompaniesStorage implements CompaniesDao {

    private SessionFactory sessionFactory;


    public CompaniesStorage() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public Companies createCompanies(Companies companies){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.saveOrUpdate(companies);

        transaction.commit();
        session.close();
        return companies;
    }

    public void deleteCompanies(Companies companies){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(companies);
        transaction.commit();
        session.close();
    }

    public  List<Companies> listCompanies(){ //read companies
        Session session = sessionFactory.openSession();
        List<Companies> companies = session.createQuery("from Companies").list();
        session.close();
        return companies;
    }

    public void updateCompanies(Companies companies){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(companies);

        transaction.commit();
        session.close();

    }

}
