package by.aston.intensive.aap.service.impl;

import by.aston.intensive.aap.dao.ProjectDao;
import by.aston.intensive.aap.model.Project;
import by.aston.intensive.aap.model.converter.ConverterDTO;
import by.aston.intensive.aap.model.dto.ProjectDto;
import by.aston.intensive.aap.service.ProjectServiceable;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectServiceable {
    private final ProjectDao projectDao;
    private final ConverterDTO<ProjectDto, Project> projectConverterDto;

    @Override
    public void save(ProjectDto dto) {
        projectConverterDto.convertDtoToEntity(dto);
    }

    @Override
    public List<Project> findAll() {
        return projectDao.findAll();
    }

    @Override
    public Project findById(Long id) {
        return projectDao.findById(id);
    }

    @Override
    public void update(ProjectDto dto, Long id) {
        Project project = projectConverterDto.convertDtoToEntity(dto);
        projectDao.update(project, id);

    }

    @Override
    public void deleteById(Long id) {
        projectDao.deleteById(id);
    }

    @Override
    public List<Project> findAllProjectsOfEmployeeByNameSurname(String employeeName, String employeeSurName) {
        return projectDao.findAllProjectsOfEmployeeByNameSurname(employeeName, employeeSurName);
    }

}
