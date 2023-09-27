package lk.ijse.gdse.gradle.service;

import lk.ijse.gdse.gradle.dto.TechLeadDTO;

import java.util.List;

public interface TechLeadService {
    TechLeadDTO saveTechLead(TechLeadDTO dto);

    TechLeadDTO updateTechLead(TechLeadDTO dto);

    void deleteTechLead(String id);

    TechLeadDTO searchTechLead(String id);

    List<TechLeadDTO> getAllTechLead();

}
