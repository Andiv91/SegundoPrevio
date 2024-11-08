package co.edu.ufps.SegundoPrevio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.ufps.SegundoPrevio.entities.Project_Assignment;

import java.util.List;

@Repository
public interface ProjectAssignmentRepository extends JpaRepository<Project_Assignment, Integer> {

    List<Project_Assignment> findByProjectId(int projectId);

    List<Project_Assignment> findByEmployeeId(int employeeId);
}