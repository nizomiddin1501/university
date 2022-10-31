package uz.developers.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.university.model.Subject;
import uz.developers.university.payload.Result;
import uz.developers.university.service.SubjectService;

import java.util.List;

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
    public Result addSubject(@RequestBody Subject subject){
        return subjectService.addSubject(subject);
    }

    @PutMapping("/{id}")
    public Result editSubject(@PathVariable Integer id, @RequestBody Subject subject){
        return subjectService.editSubject(id,subject);
    }

    @DeleteMapping("/{id}")
    public Result deleteSubject(@PathVariable Integer id){
        return subjectService.deleteSubject(id);
    }



}
