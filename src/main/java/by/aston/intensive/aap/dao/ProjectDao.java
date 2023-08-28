package by.aston.intensive.aap.dao;

import by.aston.intensive.aap.model.Project;

import java.util.List;


public interface ProjectDao extends OrganizationEntityDAO<Project> {
    List<Project> findAllProjectsOfEmployeeByNameSurname(String employeeName, String employeeSurName);
}