package uz.developers.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.university.model.Faculty;
import uz.developers.university.model.Group;
import uz.developers.university.payload.GroupDto;
import uz.developers.university.repository.FacultyRepository;
import uz.developers.university.repository.GroupRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/group")
public class GroupController {
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    FacultyRepository facultyRepository;

    //for all university
    @GetMapping
    public List<Group> getGroups(){
        return groupRepository.findAll();
    }

    //only for one university
    @GetMapping("/byUniversityId/{universityId}")
    public List<Group> getGroupsByUniversityId(@PathVariable Integer universityId){
        return groupRepository.getGroupsByUniversityIdNative(universityId);
    }

    @PostMapping
    public String addGroup(@RequestBody GroupDto groupDto){
        Group group = new Group();
        group.setName(groupDto.getName());

        Optional<Faculty> optionalFaculty = facultyRepository.findById(groupDto.getFacultyId());
        if (optionalFaculty.isEmpty()) {
            return "Such faculty is not found";
        }
        group.setFaculty(optionalFaculty.get());
        groupRepository.save(group);
        return "Group is added";
    }

    @PutMapping("/{id}")
    public String editGroup(@PathVariable Integer id, @RequestBody GroupDto groupDto){
        Optional<Group> optionalGroup = groupRepository.findById(id);
        if (optionalGroup.isEmpty()) {
            return "Group is not found";
        }
        Group group = optionalGroup.get();
        group.setName(groupDto.getName());
        boolean existsByName = groupRepository.existsByName(groupDto.getName());
        if (existsByName) {
            return "This faculty such group exist";
        }
        groupRepository.save(group);
        return "Group is edited";
    }

    @DeleteMapping("/{id}")
    public String deleteGroup(@PathVariable Integer id){
        groupRepository.deleteById(id);
        return "Group is deleted";
    }
}
