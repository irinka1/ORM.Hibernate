package hibernate.cachetest.Storages;
import hibernate.cachetest.DAOs.CustomersDAO;
import hibernate.cachetest.Entities.Customers;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CustomersStorage implements CustomersDAO {
    private SessionFactory sessionFactory;


    public CustomersStorage() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public Customers createCustomers(Customers customers){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(customers);
        transaction.commit();
        session.close();
        return customers;
    }

    public void deleteCustomers(Customers customers){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(customers);
        transaction.commit();
        session.close();
    }

    public List<Customers> listCustomers(){ //read cat
        Session session = sessionFactory.openSession();
        List<Customers> customers = session.createQuery("from Customers").list();
        session.close();
        return customers;
    }

    public void updateCustomers(Customers customers){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(customers);
        transaction.commit();
        session.close();
    }
}
