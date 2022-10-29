package uz.developers.university.controller1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uz.developers.university.model.Address;
import uz.developers.university.model.Group;
import uz.developers.university.model.Student;
import uz.developers.university.payload.GroupDto;
import uz.developers.university.payload.Result;
import uz.developers.university.payload.StudentDto;
import uz.developers.university.repository.AddressRepository;
import uz.developers.university.repository.GroupRepository;
import uz.developers.university.repository.StudentRepository;
import uz.developers.university.service.GroupService;
import uz.developers.university.service.StudentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }
    @GetMapping("/{id}")
    public Student getStudent(@PathVariable Integer id){
        return studentService.getStudent(id);
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
