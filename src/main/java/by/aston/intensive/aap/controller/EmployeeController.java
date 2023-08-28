package by.aston.intensive.aap.controller;

import by.aston.intensive.aap.model.Employee;
import by.aston.intensive.aap.model.dto.EmployeeDto;
import by.aston.intensive.aap.service.EmployeeServiceable;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(EmployeeController.REST_URL_EMPLOYEE)
@AllArgsConstructor
public class EmployeeController {

    public static final String REST_URL_EMPLOYEE = "/emp";
    private final EmployeeServiceable employeeServiceable;
    //   private final EmployeeValidator employeeValidator;


    @GetMapping("/positiongroup/{positionName}")//emp/positiongroup/Developer
    public String findAllEmployeesByPositionName(@PathVariable String positionName, Model model) {
        List<Employee> group = employeeServiceable.findAllEmployeesByPositionName(positionName);

        model.addAttribute("group", group);
        return "positiongroup";
    }

    @GetMapping("/projectteam/{projectName}") ///emp/projectteam/Big
    public String findAllEmployeesOfProjectName(@PathVariable String projectName, Model model) {
        List<Employee> teamProject = employeeServiceable.findAllEmployeesOfProjectName(projectName);
        model.addAttribute("teamProject", teamProject);
        model.addAttribute("proj", projectName);

        return "projectteam";
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void save(EmployeeDto dto) {
        //employeeValidator.validate(dto, bindingResult);
        employeeServiceable.save(dto);
    }


    @GetMapping
    public String findAll(Model model) {
        List<Employee> teamProject = employeeServiceable.findAll();
        model.addAttribute("teamProject", teamProject);
        return "projectteam";
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id) {
        return employeeServiceable.findById(id);
    }


    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(EmployeeDto dto, @PathVariable Long id) {
        //  employeeValidator.validate(dto, bindingResult);
        employeeServiceable.update(dto, id);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        employeeServiceable.deleteById(id);
    }


}



