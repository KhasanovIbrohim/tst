package com.example.tst.service;

import com.example.tst.dto.PersonalChatDto;
import com.example.tst.dto.SearchedUserDTO;
import com.example.tst.entity.PersonalChat;
import com.example.tst.entity.Users;
import com.example.tst.payload.ResultMessageObject;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonalChatService {
    List<Optional<Users>> searchUser(UUID userId,String userName);

    ResultMessageObject createPersonalChat(UUID firstUserId, UUID secondUserId);

    ResultMessageObject blockChat(UUID firstUserId, UUID secondUserId);

    ResultMessageObject unBlockChat(UUID firstUserId, UUID secondUserId);
}
