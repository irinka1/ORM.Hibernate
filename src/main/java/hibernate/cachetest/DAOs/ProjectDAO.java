package hibernate.cachetest.DAOs;
import hibernate.cachetest.Entities.Project;
import java.util.List;

public interface ProjectDAO {
    public List<Project> listProject();
    public Project createProject(Project project);
    public void updateProject(Project project);
    public void deleteProject(Project project);
}
