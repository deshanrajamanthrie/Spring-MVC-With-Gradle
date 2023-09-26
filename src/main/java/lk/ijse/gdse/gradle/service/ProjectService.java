package lk.ijse.gdse.gradle.service;

import lk.ijse.gdse.gradle.dto.ProjectDTO;
import lk.ijse.gdse.gradle.entity.Project;
import org.modelmapper.TypeToken;

import java.util.List;

public interface ProjectService {
    ProjectDTO saveProject(ProjectDTO dto);

    ProjectDTO updateProject(ProjectDTO dto);

    void deleteProject(String id);

    ProjectDTO searchProject(String id);

    List<ProjectDTO> getAllProjects();
}
