package co.edu.ufps.SegundoPrevio.controller;
import org.springframework.web.bind.annotation.*;

import co.edu.ufps.SegundoPrevio.entities.Department;
import co.edu.ufps.SegundoPrevio.services.DepartmentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{id}")
    public Optional<Department> getDepartmentById(@PathVariable Long id) {
        return departmentService.findById(id);
    }

    @PostMapping("/{departmentId}/add-employee/{employeeId}")
    public Department addEmployeeToDepartment(@PathVariable Long departmentId, @PathVariable Long employeeId) {
        return departmentService.addEmployeeToDepartment(departmentId, employeeId);
    }

    @DeleteMapping("/{departmentId}/remove-employee/{employeeId}")
    public Department removeEmployeeFromDepartment(@PathVariable Long departmentId, @PathVariable Long employeeId) {
        return departmentService.removeEmployeeFromDepartment(departmentId, employeeId);
    }
}