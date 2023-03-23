package com.example.tst.service;

import com.example.tst.dto.UserDTO;
import com.example.tst.dto.UserEditDTO;
import com.example.tst.entity.Users;
import com.example.tst.payload.ResultMessage;
import com.example.tst.payload.ResultMessageObject;

import java.util.UUID;

public interface UsersService {
    ResultMessage<Users> add(UserDTO userDTO);
    ResultMessage<Users> edit(UUID id, UserEditDTO userDTO);

    ResultMessage<Users> deleteProfile(UUID userId);

    ResultMessageObject getProfileInfo(String usernam);
}
