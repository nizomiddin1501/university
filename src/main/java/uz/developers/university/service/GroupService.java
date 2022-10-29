package uz.developers.university.service;

import uz.developers.university.model.Group;
import uz.developers.university.payload.GroupDto;
import uz.developers.university.payload.Result;

import java.util.List;

public interface GroupService {
    List<Group> getGroups();

    Group getGroup(Integer id);

    Result addGroup(GroupDto groupDto);

    Result editGroup(Integer id, GroupDto groupDto);

    Result deleteGroup(Integer id);
}
