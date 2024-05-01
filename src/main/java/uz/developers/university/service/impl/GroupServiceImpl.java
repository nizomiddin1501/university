package uz.developers.university.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import uz.developers.university.model.Faculty;
import uz.developers.university.model.Group;
import uz.developers.university.payload.GroupDto;
import uz.developers.university.payload.Result;
import uz.developers.university.repository.FacultyRepository;
import uz.developers.university.repository.GroupRepository;
import uz.developers.university.service.GroupService;

import java.util.List;
import java.util.Optional;

@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    GroupRepository groupRepository;
    @Autowired
    FacultyRepository facultyRepository;


    @Override
    public List<Group> getGroups() {
        return groupRepository.findAll();
    }

    @Override
    public List<Group> getGroupsByUniversityIdNative(Integer universityId) {
        return groupRepository.getGroupsByUniversityIdNative(universityId);
    }

    @Override
    public Result addGroup(GroupDto groupDto) {
        Group group = new Group();
        group.setName(groupDto.getName());

        Optional<Faculty> optionalFaculty = facultyRepository.findById(groupDto.getFacultyId());
        if (optionalFaculty.isEmpty()) {
            return new Result("Such faculty is not found",false);
        }
        group.setFaculty(optionalFaculty.get());
        groupRepository.save(group);
        return new Result("Group is added",true);
   }

    @Override
    public Result editGroup(Integer id, GroupDto groupDto) {
        Optional<Group> optionalGroup = groupRepository.findById(id);
        if (optionalGroup.isEmpty()) {
            return new Result("Group is not found",false);
        }
        Group group = optionalGroup.get();
        group.setName(groupDto.getName());
        boolean existsByName = groupRepository.existsByName(groupDto.getName());
        if (existsByName) {
            return new Result("This faculty such group exist",false);
        }
        groupRepository.save(group);
        return new Result("Group is edited",true);

    }

    @Override
    public Result deleteGroup(Integer id) {
        groupRepository.deleteById(id);
        return new Result("Group is deleted",true);
    }
}
