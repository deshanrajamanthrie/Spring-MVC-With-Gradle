package lk.ijse.gdse.gradle.entity;

import lk.ijse.gdse.gradle.dto.TechLeadDTO;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Project {
    @Id
    private String projectId;
    private String projectName;
    private  int memberCount;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    private TechLead techLead;
}

