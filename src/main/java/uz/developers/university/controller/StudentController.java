package uz.developers.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uz.developers.university.model.Student;
import uz.developers.university.payload.Result;
import uz.developers.university.payload.StudentDto;
import uz.developers.university.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public Page<Student> getStudentsbyPage(@RequestParam int page){
       return studentService.getStudentsByPage(page);
    }

    @GetMapping("/forUniversity/{universityId}")
    public Page<Student> getStudentsbyPageForUniversity(@PathVariable Integer universityId,@RequestParam int page){
       return studentService.getStudentsByPageForUniversity(universityId,page);
    }

    @GetMapping("/byFacultyId/{facultyId}")
    public List<Student> getStudentsByFacultyId(@PathVariable Integer facultyId){
        return studentService.getStudentsByFacultyIdNative(facultyId);
    }

    @PostMapping
    public Result addStudent(@RequestBody StudentDto studentDto){
        return studentService.addStudent(studentDto);
    }

    @PutMapping("/{id}")
    public Result editStudent(@PathVariable Integer id, @RequestBody StudentDto studentDto){
        return studentService.editStudent(id,studentDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteStudent(@PathVariable Integer id){
        return studentService.deleteStudent(id);
    }


}
