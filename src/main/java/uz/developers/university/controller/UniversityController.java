package uz.developers.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.university.model.University;
import uz.developers.university.payload.Result;
import uz.developers.university.payload.UniversityDto;
import uz.developers.university.service.UniversityService;

import java.util.List;

@RestController
@RequestMapping("/university")
public class UniversityController {
    @Autowired
    UniversityService universityService;

    @GetMapping
    public List<University> getUniversities(){
        return universityService.getUniversities();
    }
    @GetMapping("/{id}")
    public University getUniversity(@PathVariable Integer id){
        return universityService.getUniversity(id);
    }

    @PostMapping
    public Result addUniversity(@RequestBody UniversityDto universityDto){
        return universityService.addUniversity(universityDto);
    }

    @PutMapping("/{id}")
    public Result editUniversity(@PathVariable Integer id, @RequestBody UniversityDto universityDto){
        return universityService.editUniversity(id,universityDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteUniversity(@PathVariable Integer id){
        return universityService.deleteUniversity(id);
    }


}
