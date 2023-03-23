package com.example.tst.controller;

import com.example.tst.dto.PersonalChatDto;
import com.example.tst.dto.SearchedUserDTO;
import com.example.tst.entity.PersonalChat;
import com.example.tst.entity.Users;
import com.example.tst.payload.ResultMessageObject;
import com.example.tst.service.PersonalChatService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class PersonalChatControllerImp implements PersonalChatController{
    final PersonalChatService personalChatService;
    @Override
    public List<Optional<Users>> searchUser(UUID userId,String username) {
            return personalChatService.searchUser(userId,username);
    }

    @Override
    public ResultMessageObject createPersonalChat(UUID firstUserId, UUID secondUserId) {
        return personalChatService.createPersonalChat(firstUserId,secondUserId);
    }

    @Override
    public ResultMessageObject blockChat(UUID firstUserId, UUID secondUserId) {
        return personalChatService.blockChat(firstUserId,secondUserId);
    }

    @Override
    public ResultMessageObject unBlockChat(UUID firstUserId, UUID secondUserId) {
        return personalChatService.unBlockChat(firstUserId,secondUserId);
    }
}
