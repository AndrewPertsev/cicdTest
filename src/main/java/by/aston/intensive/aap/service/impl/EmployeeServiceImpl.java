package by.aston.intensive.aap.service.impl;

import by.aston.intensive.aap.dao.EmployeeDao;
import by.aston.intensive.aap.model.Employee;
import by.aston.intensive.aap.model.converter.ConverterDTO;
import by.aston.intensive.aap.model.dto.EmployeeDto;
import by.aston.intensive.aap.service.EmployeeServiceable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor

public class EmployeeServiceImpl implements EmployeeServiceable {
    private final EmployeeDao employeeDao;
    private final ConverterDTO<EmployeeDto, Employee> employeeConverterDTO;


    @Override
    public void save(EmployeeDto dto) {
        employeeConverterDTO.convertDtoToEntity(dto);
    }

    @Override
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Employee findById(Long id) {
        return employeeDao.findById(id);
    }

    @Override
    public Employee findBySurname(String login) {
        return employeeDao.findBySurname(login);
    }

    @Override
    public List<Employee> findAllEmployeesByPositionName(String positionName) {
        return employeeDao.findAllEmployeesByPositionName(positionName);
    }

    @Override
    public List<Employee> findAllEmployeesOfProjectName(String projectName) {
        return employeeDao.findAllEmployeesOfProjectName(projectName);
    }

    @Override
    public void update(EmployeeDto dto, Long id) {
        Employee user = employeeConverterDTO.convertDtoToEntity(dto);
        employeeDao.update(user, id);
    }

    @Override
    public void deleteById(Long id) {
        employeeDao.deleteById(id);
    }


}