package uz.developers.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.university.model.University;

public interface UniversityRepository extends JpaRepository<University,Integer> {

    boolean existsByName(String name);

}
