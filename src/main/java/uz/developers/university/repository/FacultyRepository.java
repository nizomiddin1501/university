package uz.developers.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.university.model.Faculty;

import java.util.List;

public interface FacultyRepository extends JpaRepository<Faculty,Integer> {


    boolean existsByNameAndUniversityId(String name, Integer university_id);

    boolean existsByName(String name);

    List<Faculty> findAllByUniversityId(Integer university_id);


}
