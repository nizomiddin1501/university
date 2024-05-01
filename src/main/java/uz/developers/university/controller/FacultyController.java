package uz.developers.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.university.model.Faculty;
import uz.developers.university.payload.FacultyDto;
import uz.developers.university.payload.Result;
import uz.developers.university.service.FacultyService;

import java.util.List;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    FacultyService facultyService;

    @GetMapping()
    public List<Faculty> getFaculties(){
        return facultyService.getFaculties();
    }

    @GetMapping("/universityId")
    public List<Faculty> getFacultiesInUniversity(@PathVariable Integer universityId){
        return facultyService.findAllByUniversityId(universityId);
    }

    @PostMapping
    public Result addFaculty(@RequestBody FacultyDto facultyDto){
        return facultyService.addFaculty(facultyDto);
    }

    @PutMapping("/{id}")
    public Result editFaculty(@PathVariable Integer id, @RequestBody FacultyDto facultyDto){
        return facultyService.editFaculty(id,facultyDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteFaculty(@PathVariable Integer id){
        return facultyService.deleteFaculty(id);
    }
}
