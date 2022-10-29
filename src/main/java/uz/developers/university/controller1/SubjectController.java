package uz.developers.university.controller1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.university.model.Student;
import uz.developers.university.model.Subject;
import uz.developers.university.payload.Result;
import uz.developers.university.payload.StudentDto;
import uz.developers.university.payload.SubjectDto;
import uz.developers.university.repository.SubjectRepository;
import uz.developers.university.service.StudentService;
import uz.developers.university.service.SubjectService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    SubjectService subjectService;

    @GetMapping
    public List<Subject> getSubjects(){
        return subjectService.getSubjects();
    }
    @GetMapping("/{id}")
    public Subject getSubject(@PathVariable Integer id){
        return subjectService.getSubject(id);
    }

    @PostMapping
    public Result addSubject(@RequestBody SubjectDto subjectDto){
        return subjectService.addSubject(subjectDto);
    }

    @PutMapping("/{id}")
    public Result editSubject(@PathVariable Integer id, @RequestBody SubjectDto subjectDto){
        return subjectService.editSubject(id,subjectDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteSubject(@PathVariable Integer id){
        return subjectService.deleteSubject(id);
    }



}
