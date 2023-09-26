package lk.ijse.gdse.gradle.entity;

import lk.ijse.gdse.gradle.dto.ProjectDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class TechLead {
    @Id
    private String id;
    private String name;
    private String address;
    @OneToMany(mappedBy = "techLead",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Project> projectList;
}
