package uz.developers.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.university.model.Subject;
import uz.developers.university.repository.SubjectRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subject")
public class SubjectController {
    @Autowired
    SubjectRepository subjectRepository;

    @GetMapping
    public List<Subject> getSubjects(){
        List<Subject> subjects = subjectRepository.findAll();
        return subjects;
    }

    @PostMapping
    public String addSubject(@RequestBody Subject subject){
        boolean existsByName = subjectRepository.existsByName(subject.getName());
        if (existsByName) {
            return "This subject is allready exist";
        }
        subjectRepository.save(subject);
        return "Subject is added";
    }
    @PutMapping("/{id}")
    public String editSubject(@PathVariable Integer id,@RequestBody Subject subject){
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if (optionalSubject.isPresent()) {
            Subject subject1 = optionalSubject.get();
            subject1.setName(subject.getName());
            subjectRepository.save(subject1);
            return "Subject is added";
        }
        return "Subject is not found";
    }
    @DeleteMapping("/{id}")
    public String deleteSubject(@PathVariable Integer id){
        subjectRepository.deleteById(id);
        return "Subject is deleted";
    }
}
