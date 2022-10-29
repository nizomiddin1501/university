package uz.developers.university.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.university.model.Subject;
import uz.developers.university.payload.Result;
import uz.developers.university.payload.SubjectDto;
import uz.developers.university.repository.SubjectRepository;
import uz.developers.university.service.SubjectService;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    SubjectRepository subjectRepository;


    @Override
    public List<Subject> getSubjects() {
        return null;
    }

    @Override
    public Subject getSubject(Integer id) {
        return null;
    }

    @Override
    public Result addSubject(SubjectDto subjectDto) {
        return null;
    }

    @Override
    public Result editSubject(Integer id, SubjectDto subjectDto) {
        return null;
    }

    @Override
    public Result deleteSubject(Integer id) {
        return null;
    }
}
