package hibernate.cachetest.Storages;


import hibernate.cachetest.DAOs.DevDAO;
import hibernate.cachetest.Entities.Developer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class StorageDeveloper implements DevDAO {
    private SessionFactory sessionFactory;



    public StorageDeveloper() {
        sessionFactory = new Configuration().configure().buildSessionFactory();

    }

    public Developer createDeveloper(Developer cat){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.saveOrUpdate(cat);

        transaction.commit();
        session.close();
        return cat;
    }

    public void deleteDeveloper(Developer cat){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(cat);
        transaction.commit();
        session.close();
    }

   public List<Developer> listDevelopers(){ //read cat
        Session session = sessionFactory.openSession();
        List<Developer> developers = session.createQuery("from Developer").list();
        session.close();
        return developers;
    }

    public void updateDeveloper(Developer developer){
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        session.update(developer);

        transaction.commit();
        session.close();

    }

    public static void main(String[] args) {
       // new StorageDeveloper();
        //System.out.println("Hello");



        StorageDeveloper storage = new StorageDeveloper();
        List<Developer> developers = storage.listDevelopers();

        for(Developer developer : developers){
            System.out.println(developer);
        }

        /*developer firstCat  = developers.get(0);
        storage.deleteDeveloper(firstCat);  //удалить кота*/

       /* StorageDeveloper storage = new StorageDeveloper();
        Developer cat = new Developer();
        developer.setName("Tom");
        developer.setBirthday(new Date());
        developer.setWeight(3f);
        developer = storage.createDeveloper(developer);

        List<Developer> developers = storage.listCats();
        developer = developers.get(2);

        developer.setName("Jerry");
        storage.updateCat(developer);*/

    }
}
