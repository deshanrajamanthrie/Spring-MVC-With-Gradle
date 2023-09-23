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
   private String id;
   private String name;
   private String address;
   private List<TechLeadDTO> list;
}
