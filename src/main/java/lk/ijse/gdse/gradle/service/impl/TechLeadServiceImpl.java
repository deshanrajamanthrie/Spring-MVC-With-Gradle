package lk.ijse.gdse.gradle.service.impl;

import lk.ijse.gdse.gradle.dto.TechLeadDTO;
import lk.ijse.gdse.gradle.entity.Project;
import lk.ijse.gdse.gradle.entity.TechLead;
import lk.ijse.gdse.gradle.repo.TechLeadRepo;
import lk.ijse.gdse.gradle.service.TechLeadService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TechLeadServiceImpl implements TechLeadService {

    @Autowired
    TechLeadRepo repo;

    @Autowired
    ModelMapper modelMapper;


    public TechLeadDTO saveTechLead(TechLeadDTO dto) {
        if (!repo.existsById(dto.getId())) {
            repo.save(modelMapper.map(dto, TechLead.class));
        } else {
            throw new RuntimeException("TechLead Id has been Already Exists!");
        }
        return dto;
    }

    public TechLeadDTO updateTechLead(TechLeadDTO dto) {
        if (repo.existsById(dto.getId())) {
            repo.save(modelMapper.map(dto, TechLead.class));
        } else {
            throw new RuntimeException("Update Failed!");
        }
        return dto;
    }

    public void deleteTechLead(String id) {
        if (repo.existsById(id)) {
            repo.delete(repo.findById(id).get());
        } else {
            throw new RuntimeException("Delete Failed!");
        }
    }

    public TechLeadDTO searchTechLead(String id) {
        if (repo.existsById(id)) {
            TechLead techLead = repo.findById(id).get();
            techLead.setProjectList(null);
            return modelMapper.map(techLead, TechLeadDTO.class);
        } else {
            throw new RuntimeException("Can Not Find The LechLead!");
        }
    }

    public List<TechLeadDTO> getAllTechLead() {
        List<TechLead> all = repo.findAll();
        for (TechLead techLead : all) {
            techLead.setProjectList(null);
        }
        return modelMapper.map(all, new TypeToken<List<TechLeadDTO>>() {
        }.getType());
    }


}
