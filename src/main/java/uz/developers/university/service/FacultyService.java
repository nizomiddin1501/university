package uz.developers.university.service;

import uz.developers.university.model.Faculty;
import uz.developers.university.payload.FacultyDto;
import uz.developers.university.payload.Result;

import java.util.List;

public interface FacultyService {
    List<Faculty> getFaculties();

    Faculty getFaculty(Integer id);

    Result addFaculty(FacultyDto facultyDto);

    Result editFaculty(Integer id, FacultyService facultyService);

    Result deleteFaculty(Integer id);
}
