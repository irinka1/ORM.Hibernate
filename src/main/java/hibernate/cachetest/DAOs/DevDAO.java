package hibernate.cachetest.DAOs;

import hibernate.cachetest.Entities.Developer;

import java.util.List;

public interface DevDAO {
    public List<Developer> listDevelopers();
    public Developer createDeveloper(Developer developer);
    public void updateDeveloper(Developer developer);
    public void deleteDeveloper(Developer developer);
}
