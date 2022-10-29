package uz.developers.university.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.university.model.University;
import uz.developers.university.payload.Result;
import uz.developers.university.payload.UniversityDto;
import uz.developers.university.repository.UniversityRepository;
import uz.developers.university.service.UniversityService;

import java.util.List;

@Service
public class UniversityServiceImpl implements UniversityService {
    @Autowired
    UniversityRepository universityRepository;

    @Override
    public List<University> getUniversities() {
        return null;
    }

    @Override
    public University getUniversity(Integer id) {
        return null;
    }

    @Override
    public Result addUniversity(UniversityDto universityDto) {
        return null;
    }

    @Override
    public Result editUniversity(Integer id, UniversityDto universityDto) {
        return null;
    }

    @Override
    public Result deleteUniversity(Integer id) {
        return null;
    }
}
