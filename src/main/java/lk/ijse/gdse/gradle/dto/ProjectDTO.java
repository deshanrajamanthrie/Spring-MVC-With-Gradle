package lk.ijse.gdse.gradle.dto;

import lombok.*;

import java.util.List;
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProjectDTO {
    private String projectId;
    private String projectName;
    private String address;
    private TechLeadDTO techLead;

}
