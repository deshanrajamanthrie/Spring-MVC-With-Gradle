package lk.ijse.gdse.gradle.controller;

import lk.ijse.gdse.gradle.dto.TechLeadDTO;
import lk.ijse.gdse.gradle.service.TechLeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tech")
@CrossOrigin
public class TechLeadController {
    @Autowired
    TechLeadService techLeadService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public void saveTechLead(@RequestBody TechLeadDTO dto){
        techLeadService.saveTechLead(dto);

    }
}
