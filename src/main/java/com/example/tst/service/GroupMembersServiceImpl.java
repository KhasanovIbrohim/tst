package com.example.tst.service;

import com.example.tst.dto.GroupDTO;
import com.example.tst.entity.GroupMembers;
import com.example.tst.entity.Groups;
import com.example.tst.entity.Users;
import com.example.tst.payload.ResultMessageObject;
import com.example.tst.repository.GroupMembersRepository;
import com.example.tst.repository.GroupRepository;
import com.example.tst.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@RequiredArgsConstructor
@Service
public class GroupMembersServiceImpl implements GroupMembersService{
    final GroupRepository groupRepository;
    final GroupMembersRepository groupMembersRepository;
    final UsersRepository usersRepository;
    @Override
    public ResultMessageObject addUser(String groupLink, String userName) {
        Optional<Groups> byLink = groupRepository.findByLink(groupLink);
        Optional<Users> byUsername = usersRepository.findByUsername(userName);
        if (byLink.isEmpty()){
            return new ResultMessageObject("group not found",false,new GroupDTO());
        } else if (byUsername.isEmpty()) {
            return new ResultMessageObject("User not found",false,new GroupDTO());
        }
        Optional<GroupMembers> inGroupUser = groupMembersRepository.isInGroupUser(byUsername.get().getId(), byLink.get().getId());
        if (inGroupUser.isEmpty()) {
            return new ResultMessageObject("user is already in group",true,inGroupUser);
        }
        GroupMembers groupMembers = GroupMembers.builder()
                .groups(new HashSet<>(List.of(byLink.get())))
                .isInGroup(true)
                .userId(new HashSet<>(List.of(byUsername.get())))
                .joinedTime(LocalDateTime.now())
                .build();
        GroupMembers save = groupMembersRepository.save(groupMembers);
        return new ResultMessageObject("user added sucsessfully",true,groupMembers);
    }
}
