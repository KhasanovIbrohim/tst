package com.example.tst.service;

import com.example.tst.dto.GroupDTO;
import com.example.tst.dto.UpdateGroupDTO;
import com.example.tst.dto.UserDTO;
import com.example.tst.entity.Groups;
import com.example.tst.entity.Users;
import com.example.tst.payload.ResultMessage;
import com.example.tst.payload.ResultMessageObject;
import com.example.tst.repository.GroupRepository;
import com.example.tst.repository.UsersRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {
    final GroupRepository groupRepository;
    final UsersRepository usersRepository;

    @Override
    public ResultMessageObject add(GroupDTO groupDTO) {
        Optional<Users> usersOptional = usersRepository.findById(groupDTO.getCreatorId());
        if (!usersOptional.isPresent()){
            return new ResultMessageObject( "Creator not found with this id " + groupDTO.getCreatorId(),false, new UserDTO());
        }
        Optional<Groups> byLink = groupRepository.findByLink(groupDTO.getLink());
        if (byLink.isPresent()){

            return new ResultMessageObject("Group already exist with this link: " + groupDTO.getLink(),false,dtoMaker(byLink.get()));
        }
        Groups group = Groups.builder()
                .name(groupDTO.getName())
                .bio("no bio yet")
                .creatorUser(usersOptional.get())
                .createdDate(LocalDateTime.now())
                .isActive(true)
                .isPrivate(groupDTO.getIsPrivate())
                .link(groupDTO.getLink())
                .build();
        groupRepository.save(group);

        return new ResultMessageObject("Group successfully created",true, dtoMaker(group));
    }

    @Override
    @Transactional
    public ResultMessageObject update(UUID userId, UpdateGroupDTO updateGroupDTO) {
        Optional<Groups> byPrevLink = groupRepository.findByLink(updateGroupDTO.getPrevLink());
        if (byPrevLink.isPresent()){
            if (!Objects.equals(byPrevLink.get().getCreatorUser().getId(),userId)){
                return new ResultMessageObject("user is not owner of this group " + userId,false,dtoMaker(byPrevLink.get()));
            }
        }else {
            return new ResultMessageObject("group not found by prevLink"+updateGroupDTO.getPrevLink(),false,new GroupDTO());
        }
        if (!Objects.equals(updateGroupDTO.getPrevLink(),updateGroupDTO.getLink())) {
            Optional<Groups> byLink = groupRepository.findByLink(updateGroupDTO.getLink());
            if (byLink.isPresent()) {
                return new ResultMessageObject("Group already exist with this link: " + updateGroupDTO.getLink(), false, dtoMaker(byLink.get()));
            }
        }
        Groups group = byPrevLink.get();
        group.setName(updateGroupDTO.getName());
        group.setBio(updateGroupDTO.getBio());
        group.setLink(updateGroupDTO.getLink());
        group.setIsPrivate(updateGroupDTO.getIsPrivate());
        groupRepository.updateGroup(group.getName(), group.getLink(), group.getBio(), group.getIsPrivate(),group.getId());
        Optional<Groups> groupOptional1 = groupRepository.findById(group.getId());
        return new ResultMessageObject("Successfully updated", true, dtoMaker(groupOptional1.get()));
    }

    @Override
    public ResultMessage delete(UUID groupId) {
        return null;
    }
    private GroupDTO dtoMaker(Groups group){
        return GroupDTO.builder()
                .name(group.getName())
                .creatorId(group.getCreatorUser().getId())
                .isPrivate(group.getIsPrivate())
                .link(group.getLink())
                .bio(group.getBio())
                .build();
    }
}
