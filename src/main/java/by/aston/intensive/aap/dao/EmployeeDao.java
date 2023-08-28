package by.aston.intensive.aap.dao;

import by.aston.intensive.aap.model.Employee;

import java.util.List;

public interface EmployeeDao extends OrganizationEntityDAO<Employee> {

    Employee findBySurname(String surname);

    List<Employee> findAllEmployeesByPositionName(String positionName);

    List<Employee> findAllEmployeesOfProjectName(String projectName);
}
