package com.example.tst.controller;

import com.example.tst.dto.PersonalChatDto;
import com.example.tst.dto.SearchedUserDTO;
import com.example.tst.entity.PersonalChat;
import com.example.tst.entity.Users;
import com.example.tst.payload.ResultMessageObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestMapping("/personal_chat")
public interface PersonalChatController {
    @CrossOrigin
    @GetMapping("/search-user/{userId}/{username}")
    List<Optional<Users>> searchUser(@PathVariable UUID userId,@PathVariable String username);

    @CrossOrigin
    @GetMapping("/create-chat/{firstUserId}/{secondUserId}")
    ResultMessageObject createPersonalChat(@PathVariable UUID firstUserId, @PathVariable UUID secondUserId);

    @CrossOrigin
    @PutMapping("/block-chat/{firstUserId}/{secondUserId}")
    ResultMessageObject blockChat(@PathVariable UUID firstUserId, @PathVariable UUID secondUserId);

    @CrossOrigin
    @PutMapping("/unblock-chat/{firstUserId}/{secondUserId}")
    ResultMessageObject unBlockChat(@PathVariable UUID firstUserId, @PathVariable UUID secondUserId);

}
