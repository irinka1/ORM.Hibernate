package hibernate.cachetest.DAOs;
import hibernate.cachetest.Entities.Customers;
import java.util.List;

public interface CustomersDAO {

    public List<Customers> listCustomers();
    public Customers createCustomers(Customers customers);
    public void updateCustomers(Customers customers);
    public void deleteCustomers(Customers customers);
}
