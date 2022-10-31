package uz.developers.university.service;

import uz.developers.university.model.Subject;
import uz.developers.university.payload.Result;

import java.util.List;

public interface SubjectService {
    List<Subject> getSubjects();

    Subject getSubject(Integer id);

    Result addSubject(Subject subject);

    Result editSubject(Integer id, Subject subject);

    Result deleteSubject(Integer id);
}
