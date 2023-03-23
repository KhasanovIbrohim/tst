package com.example.tst.controller;

import com.example.tst.dto.GroupDTO;
import com.example.tst.dto.UpdateGroupDTO;
import com.example.tst.payload.ResultMessage;
import com.example.tst.payload.ResultMessageObject;
import com.example.tst.service.GroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class GroupControllerImpl implements GroupController{

    final GroupService groupService;

    @Override
    public ResultMessageObject add(GroupDTO groupDTO) {
        return groupService.add(groupDTO);
    }

    @Override
    public ResultMessageObject update(UUID id, UpdateGroupDTO updateGroupDTO) {
        return groupService.update(id,updateGroupDTO);
    }

    @Override
    public ResultMessage delete(UUID groupId) {
        return groupService.delete(groupId);
    }
}
