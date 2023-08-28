package by.aston.intensive.aap.model.converter;

import by.aston.intensive.aap.model.Employee;
import by.aston.intensive.aap.model.dto.EmployeeDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmployeeConverterDto implements ConverterDTO<EmployeeDto, Employee> {

    @Override
    public EmployeeDto convertEntityToDto(Employee entity) {
        log.info("Convert Entity To Dto");
        return EmployeeDto.builder()
                .employeeId(entity.getEmployeeId())
                .name((entity.getName()))
                .surname(entity.getSurname())
                .position(entity.getPosition())
                .build();
    }

    @Override
    public Employee convertDtoToEntity(EmployeeDto dto) {
        log.info("Convert DTO To Entity");
        return Employee.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .position(dto.getPosition())
                .build();
    }
}
