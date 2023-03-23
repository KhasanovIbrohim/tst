package com.example.tst.service;

import com.example.tst.dto.GroupDTO;
import com.example.tst.dto.UpdateGroupDTO;
import com.example.tst.payload.ResultMessage;
import com.example.tst.payload.ResultMessageObject;

import java.util.UUID;

public interface GroupService {
    ResultMessageObject add(GroupDTO groupDTO);
    ResultMessageObject update(UUID id, UpdateGroupDTO updateGroupDTO);
    ResultMessage delete(UUID groupId);
}
