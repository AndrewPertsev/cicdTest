package by.aston.intensive.aap.model.converter;

import by.aston.intensive.aap.model.Project;
import by.aston.intensive.aap.model.dto.ProjectDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProjectConverterDto implements ConverterDTO<ProjectDto, Project> {

    @Override
    public ProjectDto convertEntityToDto(Project entity) {
      log.info("Convert Entity To Dto");
        return ProjectDto.builder()
                .projectId(entity.getProjectId())
                .name(entity.getName())
                .build();
    }

    @Override
    public Project convertDtoToEntity(ProjectDto dto) {
        log.info("Convert Dto to Entity");
        return Project.builder()
                .name(dto.getName())
                .build();
    }
}
