package by.aston.intensive.aap.controller;

import by.aston.intensive.aap.model.Project;
import by.aston.intensive.aap.model.dto.ProjectDto;
import by.aston.intensive.aap.service.EmployeeServiceable;
import by.aston.intensive.aap.service.ProjectServiceable;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(ProjectController.REST_URL_PROJECTS)
@AllArgsConstructor
public class ProjectController {
    public static final String REST_URL_PROJECTS = "/projects";
    private final ProjectServiceable projectServiceable;
    private final EmployeeServiceable employeeServiceable;


    @GetMapping("/list/{employeeName}/{employeeSurName}") //projects/list/Bill/Thi
    public String findAllProjectsOfEmployeeByNameSurname(Model model, @PathVariable String employeeName, @PathVariable String employeeSurName) {
        List<Project> participation = projectServiceable.findAllProjectsOfEmployeeByNameSurname(employeeName, employeeSurName);
        String positionName = employeeServiceable.findBySurname(employeeSurName).getPosition().getName();
        model.addAttribute("participation", participation);
        model.addAttribute("employeeName", employeeName);
        model.addAttribute("employeeSurname", employeeSurName);
        model.addAttribute("pos", positionName);
        return "participation";
    }

    @GetMapping
    public String findAll(Model model) {
        List<Project> projects = projectServiceable.findAll();
        model.addAttribute("projects", projects);
        return "participation";
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody ProjectDto dto, @PathVariable Long id) {
        projectServiceable.update(dto, id);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        projectServiceable.deleteById(id);
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {
        Project project = projectServiceable.findById(id);
        model.addAttribute("project", project);
        return "participation";
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(ProjectDto dto) {
        projectServiceable.save(dto);
    }

}



