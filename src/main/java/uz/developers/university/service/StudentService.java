package uz.developers.university.service;

import uz.developers.university.model.Student;
import uz.developers.university.payload.Result;
import uz.developers.university.payload.StudentDto;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();

    Student getStudent(Integer id);

    Result addStudent(StudentDto studentDto);

    Result editStudent(Integer id, StudentDto studentDto);

    Result deleteStudent(Integer id);
}
