package com.example.tst.controller;

import com.example.tst.payload.ResultMessageObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@RequestMapping("/group-members")
public interface GroupMembersController {

    @PostMapping("/add-user/{groupLink}/{userName}")
    ResultMessageObject addUser(@PathVariable String groupLink,@PathVariable String userName);
}
