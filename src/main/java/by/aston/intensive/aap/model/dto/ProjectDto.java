package by.aston.intensive.aap.model.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDto extends OrganizationDTOEntity {

    private Long projectId;

    private String name;

}
