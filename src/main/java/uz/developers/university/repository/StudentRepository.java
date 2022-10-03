package uz.developers.university.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.developers.university.model.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    //jpa query
    List<Student> findAllByGroup_Faculty(Integer group_faculty_id);

    //query
    @Query("select st from Student st where st.group.faculty.id =:facultyId")
    List<Student> getStudentsByFacultyId(Integer facultyId);

    //native query
    @Query(value = "select *\n" +
            "from student st\n" +
            "         join groups gr on gr.id = st.group_id\n" +
            "         join faculty f on f.id = gr.faculty_id\n" +
            "where f.id = :facultyId",nativeQuery = true)
    List<Student> getStudentsByFacultyIdNative(Integer facultyId);

    boolean existsByPhoneNumber(String phoneNumber);


    Page<Student> findAllByGroup_Faculty_UniversityId(Integer group_faculty_university_id, Pageable pageable);










}
