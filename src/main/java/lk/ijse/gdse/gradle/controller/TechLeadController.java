package lk.ijse.gdse.gradle.controller;

import lk.ijse.gdse.gradle.dto.TechLeadDTO;
import lk.ijse.gdse.gradle.service.TechLeadService;
import lk.ijse.gdse.gradle.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tech")
@CrossOrigin
public class TechLeadController {
    @Autowired
    TechLeadService techLeadService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil saveTechLead(@RequestBody TechLeadDTO dto) {
        techLeadService.saveTechLead(dto);
        return new ResponseUtil(200, "Save Successfully!", null);
    }

    @PutMapping(path = "put", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseUtil updateTechLead(@RequestBody TechLeadDTO dto) {
        techLeadService.updateTechLead(dto);
        return new ResponseUtil(200, "Update Successfully", null);

    }

    @DeleteMapping(params = {"id"})
    public ResponseUtil deleteTechLead(@RequestParam("id") String mYid) {
        techLeadService.deleteTechLead(mYid);
        return new ResponseUtil(200, "Delete Successfully", null);

    }

    @GetMapping(params = {"id"})
    public ResponseUtil searchTechLead(@RequestParam("id") String myId) {
      return new ResponseUtil(200,"OK",techLeadService.searchTechLead(myId));

    }

    @GetMapping(path = "getAll")
    public ResponseUtil getAllTech(){
        return new ResponseUtil(200,"GetAll Successfully!",techLeadService.getAllTechLead());

    }

}
