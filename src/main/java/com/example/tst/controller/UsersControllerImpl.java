package com.example.tst.controller;

import com.example.tst.dto.UserDTO;
import com.example.tst.dto.UserEditDTO;
import com.example.tst.entity.Users;
import com.example.tst.payload.ResultMessage;
import com.example.tst.payload.ResultMessageObject;
import com.example.tst.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class UsersControllerImpl implements UsersController{
    final UsersService usersService;
    ResultMessage resultMessage = new ResultMessage();
    @Override
    public ResultMessage add(UserDTO userDTO) {
        if (userDTO != null){
           resultMessage =  usersService.add(userDTO);
        }
        return resultMessage;
    }

    @Override
    public ResultMessage edit(UUID id, UserEditDTO userDTO) {
        return usersService.edit(id,userDTO);
    }

    @Override
    public ResultMessage<Users> deleteProfile(UUID userId) {
        return usersService.deleteProfile(userId);
    }

    @Override
    public ResultMessageObject getProfileInfo(String username) {
        return usersService.getProfileInfo(username);
    }
}