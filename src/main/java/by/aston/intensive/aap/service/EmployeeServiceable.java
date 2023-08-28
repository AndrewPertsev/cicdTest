package by.aston.intensive.aap.service;

import by.aston.intensive.aap.model.Employee;
import by.aston.intensive.aap.model.dto.EmployeeDto;

import java.util.List;

public interface EmployeeServiceable extends Serviceable<Employee, EmployeeDto> {

    List<Employee> findAllEmployeesByPositionName(String positionName);
    List<Employee> findAllEmployeesOfProjectName(String projectName) ;
    Employee findBySurname(String login);
}
