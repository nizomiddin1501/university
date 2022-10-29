package uz.developers.university.service;

import uz.developers.university.model.Subject;
import uz.developers.university.payload.Result;
import uz.developers.university.payload.SubjectDto;

import java.util.List;

public interface SubjectService {
    List<Subject> getSubjects();

    Subject getSubject(Integer id);

    Result addSubject(SubjectDto subjectDto);

    Result editSubject(Integer id, SubjectDto subjectDto);

    Result deleteSubject(Integer id);
}
