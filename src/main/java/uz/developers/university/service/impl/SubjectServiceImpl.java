package uz.developers.university.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.university.model.Subject;
import uz.developers.university.payload.Result;
import uz.developers.university.repository.SubjectRepository;
import uz.developers.university.service.SubjectService;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    SubjectRepository subjectRepository;


    @Override
    public List<Subject> getSubjects() {
        return subjectRepository.findAll();
    }

    @Override
    public Subject getSubject(Integer id) {
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if (optionalSubject.isPresent()) {
            return optionalSubject.get();
        }
        return null;
    }

    @Override
    public Result addSubject(Subject subject) {
        boolean existsByName = subjectRepository.existsByName(subject.getName());
        if (existsByName) {
            return new Result("This subject is allready exist",false);
        }
        subjectRepository.save(subject);
        return new Result("Subject is added",true);
    }

    @Override
    public Result editSubject(Integer id, Subject subject) {
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if (optionalSubject.isEmpty()) {
            return new Result("Subject is not found",false);
        }
        Subject subject1 = optionalSubject.get();
        subject1.setName(subject.getName());
        subjectRepository.save(subject1);
        return new Result("Subject is edited",true);
    }

    @Override
    public Result deleteSubject(Integer id) {
        subjectRepository.findById(id);
        return new Result("Subject is deleted",true);
    }
}
