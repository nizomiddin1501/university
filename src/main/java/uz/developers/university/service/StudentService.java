package uz.developers.university.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import uz.developers.university.model.Student;
import uz.developers.university.payload.Result;
import uz.developers.university.payload.StudentDto;

import java.util.List;

public interface StudentService {


    Page<Student> getStudentsByPage(int page);

    Page<Student> getStudentsByPageForUniversity(Integer universityId, int page);

    List<Student> getStudentsByFacultyIdNative(Integer facultyId);

    Result addStudent(StudentDto studentDto);

    Result editStudent(Integer id, StudentDto studentDto);

    Result deleteStudent(Integer id);



}
