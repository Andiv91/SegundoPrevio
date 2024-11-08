package co.edu.ufps.SegundoPrevio.controller;
import org.springframework.web.bind.annotation.*;

import co.edu.ufps.SegundoPrevio.entities.Employee;
import co.edu.ufps.SegundoPrevio.services.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return EmployeeService.listAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.findById(id);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        return employeeService.updateEmployee(id, employeeDetails);
    }

    @GetMapping("/{id}/salary")
    public Double getEmployeeSalary(@PathVariable Long id) {
        return employeeService.getEmployeeSalary(id);
    }
}