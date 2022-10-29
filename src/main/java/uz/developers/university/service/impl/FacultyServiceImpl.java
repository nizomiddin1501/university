package uz.developers.university.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.university.model.Faculty;
import uz.developers.university.payload.FacultyDto;
import uz.developers.university.payload.Result;
import uz.developers.university.repository.FacultyRepository;
import uz.developers.university.service.FacultyService;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {
    @Autowired
    FacultyRepository facultyRepository;

    @Override
    public List<Faculty> getFaculties() {
        return null;
    }

    @Override
    public Faculty getFaculty(Integer id) {
        return null;
    }

    @Override
    public Result addFaculty(FacultyDto facultyDto) {
        return null;
    }

    @Override
    public Result editFaculty(Integer id, FacultyService facultyService) {
        return null;
    }

    @Override
    public Result deleteFaculty(Integer id) {
        return null;
    }
}
