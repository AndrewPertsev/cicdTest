package by.aston.intensive.aap.model.dto;


import by.aston.intensive.aap.model.Position;
import lombok.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto extends OrganizationDTOEntity {

    private Long employeeId;

    private String name;

    private String surname;

    private Position position;



}
