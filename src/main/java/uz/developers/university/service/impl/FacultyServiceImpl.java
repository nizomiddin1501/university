package uz.developers.university.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import uz.developers.university.model.Faculty;
import uz.developers.university.model.University;
import uz.developers.university.payload.FacultyDto;
import uz.developers.university.payload.Result;
import uz.developers.university.repository.FacultyRepository;
import uz.developers.university.repository.UniversityRepository;
import uz.developers.university.service.FacultyService;

import java.util.List;
import java.util.Optional;

@Service
public class FacultyServiceImpl implements FacultyService {
    @Autowired
    FacultyRepository facultyRepository;
    @Autowired
    UniversityRepository universityRepository;
    private Integer id;
    private FacultyDto facultyDto;

    @Override
    public List<Faculty> getFaculties() {
        return facultyRepository.findAll();
    }

    @Override
    public List<Faculty> findAllByUniversityId(Integer universityId) {
        return facultyRepository.findAllByUniversityId(universityId);
    }

    @Override
    public Result addFaculty(FacultyDto facultyDto) {
        boolean exists = facultyRepository.existsByNameAndUniversityId(facultyDto.getName(), facultyDto.getUniversityId());
        if (exists) {
            return new Result("This university such faculty exist", false);
        }
        Faculty faculty = new Faculty();
        faculty.setName(facultyDto.getName());
        Optional<University> optionalUniversity = universityRepository.findById(facultyDto.getUniversityId());
        if (optionalUniversity.isEmpty()) {
            return new Result("University is not found", false);
        }
        faculty.setUniversity(optionalUniversity.get());
        facultyRepository.save(faculty);
        return new Result("Faculty is saved", true);
    }

    @Override
    public Result editFaculty(Integer id, FacultyDto facultyDto) {
        Optional<Faculty> optionalFaculty = facultyRepository.findById(id);
        if (optionalFaculty.isEmpty()) {
            return new Result("Faculty not found", false);
        }
        Faculty faculty = optionalFaculty.get();
        faculty.setName(facultyDto.getName());

        Optional<University> optionalUniversity = universityRepository.findById(facultyDto.getUniversityId());
        if (optionalUniversity.isEmpty()) {
            return new Result("Such university is not found", false);
        }
        boolean existsByName = facultyRepository.existsByName(facultyDto.getName());
        if (existsByName) {
            return new Result("This university such faculty exist", false);
        }
        facultyRepository.save(faculty);
        return new Result("Faculty is edited", false);
    }

    @Override
    public Result deleteFaculty(Integer id) {
        try {
            facultyRepository.deleteById(id);
            return new Result("Faculty is deleted", false);
        } catch (Exception e) {
            return new Result("Error deleting", false);
        }
    }


}
