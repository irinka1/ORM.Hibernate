package hibernate.cachetest.DAOs;
import hibernate.cachetest.Entities.Skills;
import java.util.List;

public interface SkillsDAO {

    public List<Skills> listSkills();
    public Skills createSkills(Skills skills);
    public void updateSkills(Skills skills);
    public void deleteSkills(Skills skills);
}
