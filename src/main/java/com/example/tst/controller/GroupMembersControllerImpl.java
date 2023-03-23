package com.example.tst.controller;

import com.example.tst.payload.ResultMessageObject;
import com.example.tst.service.GroupMembersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
@RequiredArgsConstructor
@RestController
public class GroupMembersControllerImpl implements GroupMembersController{
    final GroupMembersService groupMembersService;
    @Override
    public ResultMessageObject addUser(String groupLink, String userName) {
        return groupMembersService.addUser(groupLink,userName);
    }
}
