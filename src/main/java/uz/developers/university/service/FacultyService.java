package uz.developers.university.service;

import uz.developers.university.model.Faculty;
import uz.developers.university.payload.FacultyDto;
import uz.developers.university.payload.Result;

import java.util.List;

public interface FacultyService {
    List<Faculty> getFaculties();

    List<Faculty> findAllByUniversityId(Integer universityId);

    Result addFaculty(FacultyDto facultyDto);

    Result editFaculty(Integer id, FacultyDto facultyDto);

    Result deleteFaculty(Integer id);

}
