package lk.ijse.gdse.gradle.dto;

import lombok.*;

import javax.persistence.Entity;
import java.util.List;
import java.util.SplittableRandom;
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@ToString
public class TechLeadDTO {
   public TechLeadDTO(String id) {
      this.id = id;
   }
   private String id;
   private String name;
   private String address;
   private List<ProjectDTO> list;

   public TechLeadDTO(String id, String name, String address) {
      this.id = id;
      this.name = name;
      this.address = address;

   }
}
