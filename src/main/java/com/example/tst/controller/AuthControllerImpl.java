package com.example.tst.controller;

import com.example.tst.dto.UserDTO;
import com.example.tst.payload.ResultMessage;
import com.example.tst.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController{

    final AuthService authService;

    @Override
    public ResultMessage login(UserDTO userDTO) {
        return authService.login(userDTO.getEmail());
    }

    @Override
    public ResultMessage checkReliable(UUID userId, String code) {
        return authService.checkReliable(userId,code);
    }
}
