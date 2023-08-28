package by.aston.intensive.aap.service.validation;

import by.aston.intensive.aap.dao.EmployeeDao;
import by.aston.intensive.aap.model.Employee;
import by.aston.intensive.aap.model.dto.EmployeeDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class EmployeeValidator implements Validable {
    private final EmployeeDao employeeDao;

    @Override
    public boolean validate(Object o) {
        Employee employee = (Employee) o;

        if (employee != null ) { return true;}

        return false;
    }

    @Override
    public boolean validateDto(Object o) {
        EmployeeDto employeeDto = (EmployeeDto) o;

        if (employeeDto != null ) { return true;}

        return false;
    }

}
