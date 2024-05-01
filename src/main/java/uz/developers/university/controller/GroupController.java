package uz.developers.university.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.developers.university.model.Group;
import uz.developers.university.payload.GroupDto;
import uz.developers.university.payload.Result;
import uz.developers.university.service.GroupService;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {
    @Autowired
    GroupService groupService;

    @GetMapping
    public List<Group> getGroups(){
        return groupService.getGroups();
    }

    @GetMapping("/{universityId}")
    public List<Group> getGroupsByUniversityId(@PathVariable Integer universityId){
        return groupService.getGroupsByUniversityIdNative(universityId);
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
