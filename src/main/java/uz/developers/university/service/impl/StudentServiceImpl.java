package uz.developers.university.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import uz.developers.university.model.Address;
import uz.developers.university.model.Group;
import uz.developers.university.model.Student;
import uz.developers.university.payload.Result;
import uz.developers.university.payload.StudentDto;
import uz.developers.university.repository.AddressRepository;
import uz.developers.university.repository.GroupRepository;
import uz.developers.university.repository.StudentRepository;
import uz.developers.university.service.StudentService;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    AddressRepository addressRepository;

    @Override
    public Page<Student> getStudentsByPage(int page) {
        Pageable pageable = PageRequest.of(page,10);
        Page<Student> studentPage = studentRepository.findAll(pageable);
        return studentPage;
    }

    @Override
    public Page<Student> getStudentsByPageForUniversity(Integer universityId, int page) {
        Pageable pageable = PageRequest.of(page,10);
        Page<Student> allByGroup_faculty_universityId = studentRepository.findAllByGroup_Faculty_UniversityId(universityId, pageable);
        return allByGroup_faculty_universityId;
    }

    @Override
    public List<Student> getStudentsByFacultyIdNative(Integer facultyId) {
        return studentRepository.getStudentsByFacultyIdNative(facultyId);
    }

    @Override
    public Result addStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());

        boolean existsByPhoneNumber = studentRepository.existsByPhoneNumber(studentDto.getPhoneNumber());
        if (existsByPhoneNumber) {
            return new Result("Such student already exist",false);
        }
        Optional<Group> optionalGroup = groupRepository.findById(studentDto.getGroupId());
        if (optionalGroup.isEmpty())
            return new Result("Such group is not found",false);
        Optional<Address> optionalAddress = addressRepository.findById(studentDto.getAddressId());
        if (optionalAddress.isEmpty())
            return new Result("Such address is not found",false);

        student.setAddress(optionalAddress.get());
        student.setGroup(optionalGroup.get());

        studentRepository.save(student);
        return new Result("Student is added",true);
    }

    @Override
    public Result editStudent(Integer id, StudentDto studentDto) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isEmpty()) {
            return new Result("Such student is not found",false);
        }
        Student student = optionalStudent.get();
        student.setFirstName(studentDto.getFirstName());
        student.setLastName(studentDto.getLastName());

        boolean exists = studentRepository.existsByPhoneNumber(studentDto.getPhoneNumber());
        if (exists) {
            return new Result("Such phoneNumber already exist",false);
        }
        studentRepository.save(student);
        return new Result("Student is edited",true);
    }

    @Override
    public Result deleteStudent(Integer id) {
        studentRepository.deleteById(id);
        return new Result("Student is deleted",true);
    }
}
