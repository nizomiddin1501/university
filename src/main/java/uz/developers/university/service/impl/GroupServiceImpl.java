package uz.developers.university.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.developers.university.repository.GroupRepository;
import uz.developers.university.service.GroupService;
@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    GroupRepository groupRepository;


}
