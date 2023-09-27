package lk.ijse.gdse.gradle.entity;

import lk.ijse.gdse.gradle.dto.ProjectDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    @ToString.Exclude
    @OneToMany(mappedBy = "techLead",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Project> projectList;
}
