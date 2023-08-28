package by.aston.intensive.aap.dao.impl;

import by.aston.intensive.aap.dao.EmployeeDao;
import by.aston.intensive.aap.model.Employee;
import by.aston.intensive.aap.model.Position;
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
public class EmployeeDaoImpl implements EmployeeDao {

    private static final String FIND_ALL_EMPLOYEES_OF_PROJECT = "SELECT Employee.id, Employee.Name, Employee.Surname, Employee.Position_Id from Employee inner join employee_projects on Employee.id=employee_projects.employee_id\n" +
            "            inner join Projects on Projects.id=employee_projects.project_id where Projects.Name=?";
    private static final String FIND_ALL_EMPLOYEE_BY_POSITION = "SELECT Employee.id, Employee.Name, Employee.Surname, Employee.Position_Id from Employee inner join Positions on Employee.position_id=Positions.Id\n" +
            "where Positions.Name=?";

    @PersistenceContext
    private final EntityManager entityManager;


    @Override
    public List<Employee> findAllEmployeesOfProjectName(String projName) {

        return entityManager.createNativeQuery(FIND_ALL_EMPLOYEES_OF_PROJECT, Employee.class)
                .setParameter(1, projName)
                .getResultList();
    }

    @Override
    public List<Employee> findAllEmployeesByPositionName(String positionName) {
        return entityManager.createNativeQuery(FIND_ALL_EMPLOYEE_BY_POSITION, Employee.class)
                .setParameter(1, positionName)
                .getResultList();
    }

    @Override
    public void save(Employee entity) {
        entityManager.persist(entity);
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM  Employee e", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(Long id) {
        return entityManager.find(Employee.class, id);

    }

    @Override
    public void update(Employee entity, Long id) {
        entity.setEmployeeId(id);
        entityManager.merge(entity);
    }

    @Override
    public void deleteById(Long id) {
        entityManager.remove(entityManager.find(Position.class, id));

    }

    @Override
    public Employee findBySurname(String surname) {
        TypedQuery<Employee> query = entityManager.createQuery("SELECT e FROM Employee e WHERE e.surname = :surname", Employee.class)
                .setParameter("surname", surname);
        return query.getSingleResult();
    }
}
