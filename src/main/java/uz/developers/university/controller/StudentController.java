package uz.developers.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import uz.developers.university.model.Address;
import uz.developers.university.model.Group;
import uz.developers.university.model.Student;
import uz.developers.university.payload.StudentDto;
import uz.developers.university.repository.AddressRepository;
import uz.developers.university.repository.GroupRepository;
import uz.developers.university.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    AddressRepository addressRepository;

    //for all students of all university
    @GetMapping
    public Page<Student> getStudentsbyPage(@RequestParam int page){
        Pageable pageable = PageRequest.of(page,10);
        Page<Student> studentPage = studentRepository.findAll(pageable);
        return studentPage;
    }

    // for all students of university
    @GetMapping("/forUniversity/{universityId}")
    public Page<Student> getStudentsbyPageForuniversity(@PathVariable Integer universityId,@RequestParam int page){
        Pageable pageable = PageRequest.of(page,10);
        studentRepository.findAllByGroup_Faculty_UniversityId(universityId,pageable);
    }

    @GetMapping("/byFacultyId/{facultyId}")
    public List<Student> getStudentsByUniversityId(@PathVariable Integer facultyId){
        return studentRepository.getStudentsByFacultyIdNative(facultyId);
    }

    @PostMapping
    public String addStudent(@RequestBody StudentDto studentDto){
        Student student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());

        boolean existsByPhoneNumber = studentRepository.existsByPhoneNumber(studentDto.getPhoneNumber());
        if (existsByPhoneNumber) {
            return "Such student already exist";
        }
        Optional<Group> optionalGroup = groupRepository.findById(studentDto.getGroupId());
        if (optionalGroup.isEmpty())
            return "Such group is not found";
        Optional<Address> optionalAddress = addressRepository.findById(studentDto.getAddressId());
        if (optionalAddress.isEmpty())
            return "Such address is not found";

        student.setAddress(optionalAddress.get());
        student.setGroup(optionalGroup.get());

        studentRepository.save(student);
        return "Student is added";
    }


    @PutMapping("/{id}")
    public String editStudent(@PathVariable Integer id,@RequestBody StudentDto studentDto){

        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isEmpty()) {
            return "Such student is not found";
        }
        Student student = optionalStudent.get();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());

        boolean exists = studentRepository.existsByPhoneNumber(studentDto.getPhoneNumber());
        if (exists) {
            return "Such phoneNumber already exist";
        }
        studentRepository.save(student);
        return "Student is edited";

    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable Integer id){
        studentRepository.deleteById(id);
        return "Student is deleted";
    }


}
