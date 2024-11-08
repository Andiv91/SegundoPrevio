package co.edu.ufps.SegundoPrevio.controller;
import org.springframework.web.bind.annotation.*;

import co.edu.ufps.SegundoPrevio.entities.Project;
import co.edu.ufps.SegundoPrevio.services.ProjectService;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectService.getAllProjects();
    }

    @PutMapping("/{id}")
    public Project updateProject(@PathVariable Long id, @RequestBody Project projectDetails) {
        return projectService.updateProject(id, projectDetails);
    }
}
