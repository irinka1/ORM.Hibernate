package hibernate.cachetest.DAOs;
import hibernate.cachetest.Companies;

import java.util.List;

public interface CompaniesDao {
    public List<Companies> listCompanies();
    public Companies createCompanies(Companies companies);
    public void updateCompanies(Companies companies);
    public void deleteCompanies(Companies companies);
}
