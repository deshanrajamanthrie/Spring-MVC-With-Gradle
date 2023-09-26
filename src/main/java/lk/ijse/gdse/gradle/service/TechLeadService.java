package lk.ijse.gdse.gradle.service;

import lk.ijse.gdse.gradle.dto.TechLeadDTO;

public interface TechLeadService {
    TechLeadDTO saveTechLead(TechLeadDTO dto);
    TechLeadDTO updateTechLead(TechLeadDTO dto);
     void deleteTechLead(String id);
     TechLeadDTO searchTechLead(String id);
}
