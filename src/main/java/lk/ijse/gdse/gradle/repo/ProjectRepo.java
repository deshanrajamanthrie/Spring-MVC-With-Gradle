package lk.ijse.gdse.gradle.repo;

import lk.ijse.gdse.gradle.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project,String> {
}
