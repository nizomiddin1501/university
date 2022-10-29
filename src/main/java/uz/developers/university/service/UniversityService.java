package uz.developers.university.service;

import uz.developers.university.model.University;
import uz.developers.university.payload.Result;
import uz.developers.university.payload.UniversityDto;

import java.util.List;

public interface UniversityService {
    List<University> getUniversities();

    University getUniversity(Integer id);

    Result addUniversity(UniversityDto universityDto);

    Result editUniversity(Integer id, UniversityDto universityDto);

    Result deleteUniversity(Integer id);
}
