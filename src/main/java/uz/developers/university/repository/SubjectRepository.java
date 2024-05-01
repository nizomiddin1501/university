package uz.developers.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.developers.university.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject,Integer> {

    boolean existsByName(String name);


}
