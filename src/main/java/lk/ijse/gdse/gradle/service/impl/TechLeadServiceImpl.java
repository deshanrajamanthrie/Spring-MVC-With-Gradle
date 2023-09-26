package lk.ijse.gdse.gradle.service.impl;

import lk.ijse.gdse.gradle.dto.TechLeadDTO;
import lk.ijse.gdse.gradle.entity.TechLead;
import lk.ijse.gdse.gradle.repo.TechLeadRepo;
import lk.ijse.gdse.gradle.service.TechLeadService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

}
