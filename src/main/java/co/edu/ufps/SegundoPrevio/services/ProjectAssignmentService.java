package co.edu.ufps.SegundoPrevio.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ufps.SegundoPrevio.entities.Project_Assignment;
import co.edu.ufps.SegundoPrevio.repositories.EmployeeRepository;
import co.edu.ufps.SegundoPrevio.repositories.ProjectAssignmentRepository;
import co.edu.ufps.SegundoPrevio.repositories.ProjectRepository;
import co.edu.ufps.SegundoPrevio.repositories.RoleRepository;

import java.util.Optional;

@Service
public class ProjectAssignmentService {

    @Autowired
    private ProjectAssignmentRepository projectAssignmentRepository;

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private RoleRepository roleRepository;

    public Project_Assignment assignEmployeeToProjectWithRole(int projectId, int employeeId, int roleId) {
        // Verificar si el proyecto existe
        var project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with id " + projectId));

        // Verificar si el empleado existe
        var employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id " + employeeId));

        // Verificar si el rol existe
        var role = roleRepository.findById(roleId)
                .orElseThrow(() -> new ResourceNotFoundException("Role not found with id " + roleId));

        // Crear una nueva asignación de proyecto
        Project_Assignment projectAssignment = new Project_Assignment();
        projectAssignment.setProjectId(projectId);
        projectAssignment.setEmployeeId(employeeId);
        projectAssignment.setRoleId(roleId);

        // Guardar la asignación en la base de datos
        return projectAssignmentRepository.save(projectAssignment);
    }
}