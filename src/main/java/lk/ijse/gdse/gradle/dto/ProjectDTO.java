package lk.ijse.gdse.gradle.dto;

import lombok.*;

import java.util.List;
@AllArgsConstructor
@Data

@NoArgsConstructor

public class ProjectDTO {
    private String projectId;
    private String projectName;
    private int memberCount;
    private TechLeadDTO techLead;

}
