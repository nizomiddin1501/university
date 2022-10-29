package uz.developers.university.controller1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.university.model.Address;
import uz.developers.university.model.Subject;
import uz.developers.university.model.University;
import uz.developers.university.payload.Result;
import uz.developers.university.payload.SubjectDto;
import uz.developers.university.payload.UniversityDto;
import uz.developers.university.repository.AddressRepository;
import uz.developers.university.repository.UniversityRepository;
import uz.developers.university.service.SubjectService;
import uz.developers.university.service.UniversityService;

import java.util.List;
import java.util.Optional;

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
