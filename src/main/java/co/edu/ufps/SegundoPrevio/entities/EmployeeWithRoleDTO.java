package co.edu.ufps.SegundoPrevio.entities;

public class EmployeeWithRoleDTO {
    private Employee employee;
    private String roleName;

    public EmployeeWithRoleDTO(Employee employee, String roleName) {
        this.employee = employee;
        this.roleName = roleName;
    }

    // Getters y setters
}