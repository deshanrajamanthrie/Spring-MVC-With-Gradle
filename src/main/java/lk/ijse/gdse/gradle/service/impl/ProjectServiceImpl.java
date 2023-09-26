package lk.ijse.gdse.gradle.service.impl;

import lk.ijse.gdse.gradle.entity.Project;
import lk.ijse.gdse.gradle.repo.ProjectRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProjectServiceImpl {
    @Autowired
    ModelMapper mapper;

    @Autowired
    ProjectRepo projectRepo;

    public void saveProject(Project project){
        projectRepo.save(project);

    }


}
