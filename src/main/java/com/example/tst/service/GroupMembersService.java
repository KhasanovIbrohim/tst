package com.example.tst.service;

import com.example.tst.payload.ResultMessageObject;

import java.util.UUID;

public interface GroupMembersService {
    ResultMessageObject addUser(String groupLink, String userName);
}
