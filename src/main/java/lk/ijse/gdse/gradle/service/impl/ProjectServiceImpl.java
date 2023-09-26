package lk.ijse.gdse.gradle.service.impl;

import lk.ijse.gdse.gradle.dto.ProjectDTO;
import lk.ijse.gdse.gradle.entity.Project;
import lk.ijse.gdse.gradle.repo.ProjectRepo;
import lk.ijse.gdse.gradle.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    ModelMapper mapper;

    @Autowired
    ProjectRepo projectRepo;

    @Override
    public ProjectDTO saveProject(ProjectDTO dto) {
        if (!projectRepo.existsById(dto.getProjectId())) {
            projectRepo.save(mapper.map(dto, Project.class));
        } else {
            throw new RuntimeException("Customer Already Exists!");
        }
        return dto;
    }

    @Override
    public ProjectDTO updateProject(ProjectDTO dto) {
        if (projectRepo.existsById(dto.getProjectId())) {
            projectRepo.save(mapper.map(dto, Project.class));
        } else {
            throw new RuntimeException("Update Failed!Try Again");
        }
        return dto;
    }

    @Override
    public void deleteProject(String id) {
        if (projectRepo.existsById(id)) {
            projectRepo.delete(projectRepo.findById(id).get());
        } else {
            throw new RuntimeException("Delete Failed!");
        }
    }

    @Override
    public ProjectDTO searchProject(String id) {
        if (projectRepo.existsById(id)) {
            Project project = projectRepo.findById(id).get();
            ProjectDTO map = mapper.map(project, ProjectDTO.class);

            return map;


        } else {
            throw new RuntimeException("Project Has Not Exists!");
        }

    }

    @Override
    public List<ProjectDTO> getAllProjects() {
        return mapper.map(projectRepo.findAll(), new TypeToken<List<ProjectDTO>>() {
        }.getType());
    }

}
