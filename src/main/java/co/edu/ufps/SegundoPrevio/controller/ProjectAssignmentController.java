package co.edu.ufps.SegundoPrevio.controller;
import org.springframework.web.bind.annotation.*;

import co.edu.ufps.SegundoPrevio.entities.EmployeeWithRoleDTO;
import co.edu.ufps.SegundoPrevio.entities.Project_Assignment;
import co.edu.ufps.SegundoPrevio.services.ProjectAssignmentService;

import java.util.List;

@RestController
@RequestMapping("/api/project-assignments")
public class ProjectAssignmentController {
    private final ProjectAssignmentService projectAssignmentService;

    public ProjectAssignmentController(ProjectAssignmentService projectAssignmentService) {
        this.projectAssignmentService = projectAssignmentService;
    }

    @PostMapping("/{projectId}/add-employee/{employeeId}/role/{roleId}")
    public Project_Assignment assignEmployeeToProjectWithRole(@PathVariable Long projectId, 
                                                             @PathVariable Long employeeId, 
                                                             @PathVariable Long roleId) {
        return projectAssignmentService.assignEmployeeToProjectWithRole(projectId, employeeId, roleId);
    }

    @GetMapping("/project/{projectId}/employees")
    public List<EmployeeWithRoleDTO> getEmployeesWithRoleByProject(@PathVariable Long projectId) {
        return projectAssignmentService.getEmployeesWithRoleByProject(projectId);
    }
}