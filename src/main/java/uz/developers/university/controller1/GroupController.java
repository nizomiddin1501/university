package uz.developers.university.controller1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.university.model.Faculty;
import uz.developers.university.model.Group;
import uz.developers.university.payload.FacultyDto;
import uz.developers.university.payload.GroupDto;
import uz.developers.university.payload.Result;
import uz.developers.university.repository.FacultyRepository;
import uz.developers.university.repository.GroupRepository;
import uz.developers.university.service.FacultyService;
import uz.developers.university.service.GroupService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/group")
public class GroupController {
    @Autowired
    GroupService groupService;

    @GetMapping
    public List<Group> getGroups(){
        return groupService.getGroups();
    }
    @GetMapping("/{id}")
    public Group getGroup(@PathVariable Integer id){
        return groupService.getGroup(id);
    }

    @PostMapping
    public Result addGroup(@RequestBody GroupDto groupDto){
        return groupService.addGroup(groupDto);
    }

    @PutMapping("/{id}")
    public Result editGroup(@PathVariable Integer id, @RequestBody GroupDto groupDto){
        return groupService.editGroup(id,groupDto);
    }

    @DeleteMapping("/{id}")
    public Result deleteGroup(@PathVariable Integer id){
        return groupService.deleteGroup(id);
    }


}
