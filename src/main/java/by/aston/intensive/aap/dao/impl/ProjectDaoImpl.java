package by.aston.intensive.aap.dao.impl;

import by.aston.intensive.aap.dao.ProjectDao;
import by.aston.intensive.aap.model.Project;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Slf4j
@Repository
@AllArgsConstructor
public class ProjectDaoImpl implements ProjectDao {

    private static final String FIND_ALL_PROJECT_BY_EMPLOYEE_NAME_SURNAME = "SELECT Projects.id, Projects.Name from Projects inner join employee_projects  on Projects.id=employee_projects.project_id \n" +
            "inner join Employee on Employee.id=employee_projects.employee_id where Employee.Name=? and Employee.Surname=?";

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public List<Project> findAllProjectsOfEmployeeByNameSurname(String employeeName, String employeeSurName) {
        List<Project> projects = entityManager.createNativeQuery(FIND_ALL_PROJECT_BY_EMPLOYEE_NAME_SURNAME, Project.class)
                .setParameter(1, employeeName)
                .setParameter(2, employeeSurName)
                .getResultList();

        return projects;
    }


    @Override
    public void save(Project entity) {
        entityManager.persist(entity);

    }

    @Override
    public List<Project> findAll() {
        TypedQuery<Project> query = entityManager.createQuery("SELECT p FROM  Project p", Project.class);
        return query.getResultList();
    }

    @Override
    public Project findById(Long id) {
        return entityManager.find(Project.class, id);
    }

    @Override
    public void update(Project entity, Long id) {
        entity.setProjectId(id);
        entityManager.merge(entity);
    }

    @Override
    public void deleteById(Long id) {
        entityManager.remove(entityManager.find(Project.class, id));
    }

}
