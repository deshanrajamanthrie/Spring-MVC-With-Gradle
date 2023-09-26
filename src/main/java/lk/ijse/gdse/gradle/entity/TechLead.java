package lk.ijse.gdse.gradle.entity;

import lk.ijse.gdse.gradle.dto.ProjectDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
@Entity

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TechLead {
    @Id
    private String id;
    private String name;
    private String address;
    @OneToMany(mappedBy = "techLead",cascade = CascadeType.ALL)
    private List<Project> projectList;
}
