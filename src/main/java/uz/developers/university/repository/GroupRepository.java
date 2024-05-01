package uz.developers.university.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import uz.developers.university.model.Group;

import java.util.List;

public interface GroupRepository extends JpaRepository<Group,Integer> {

    //jpa Query
    List<Group> findAllByFaculty_UniversityId(Integer faculty_university_id);

    //Query
    @Query("select gr from groups gr where gr.faculty.university.id =:universityId")
    List<Group> getGroupsByUniversityId(Integer universityId);


    //Native Query

    @Query(value = "select *\n" +
            "from groups g\n" +
            "         join faculty f on f.id = g.faculty_id\n" +
            "         join university u on u.id = f.university_id\n" +
            "where u.id = :universityId",nativeQuery = true)
    List<Group> getGroupsByUniversityIdNative(Integer universityId);

    boolean existsByName(String name);






}
