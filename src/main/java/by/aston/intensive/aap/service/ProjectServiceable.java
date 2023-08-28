package by.aston.intensive.aap.service;

import by.aston.intensive.aap.model.Project;
import by.aston.intensive.aap.model.dto.ProjectDto;

import java.util.List;



public interface ProjectServiceable extends Serviceable<Project, ProjectDto> {

    List<Project> findAllProjectsOfEmployeeByNameSurname(String employeeName, String employeeSurName);





}
