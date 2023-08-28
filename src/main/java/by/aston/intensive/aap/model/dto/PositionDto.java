package by.aston.intensive.aap.model.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PositionDto extends OrganizationDTOEntity {

    private Long positionId;

    private String name;

}
