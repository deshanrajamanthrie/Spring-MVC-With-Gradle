package lk.ijse.gdse.gradle.controller;

import lk.ijse.gdse.gradle.dto.ProjectDTO;
import lk.ijse.gdse.gradle.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("project")
@CrossOrigin
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void saveProjects(@RequestBody ProjectDTO projectDTO) {
        projectService.saveProject(projectDTO);
    }

    @PutMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void updateProjects(@RequestBody ProjectDTO projectDTO) {
        projectService.updateProject(projectDTO);
    }

    @DeleteMapping(params = {"projectId"})
    public void deleteProjects(@RequestParam("projectId") String myId) {
        projectService.deleteProject(myId);
    }

    @GetMapping(params = {"projectId"})
    public ProjectDTO searchProjects(@RequestParam("projectId") String id) {
        ProjectDTO projectDTO = projectService.searchProject(id);
        return projectDTO;
    }

    @GetMapping(path = "search")
    public List<ProjectDTO> getAllProjects() {
        List<ProjectDTO> allProjects = projectService.getAllProjects();
        return allProjects;
    }


}
