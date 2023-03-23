package com.example.tst.controller;

import com.example.tst.dto.UserDTO;
import com.example.tst.dto.UserEditDTO;
import com.example.tst.entity.Users;
import com.example.tst.payload.ResultMessage;
import com.example.tst.payload.ResultMessageObject;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/user")
public interface UsersController {
    @CrossOrigin
    @PostMapping("/sign-up")
    ResultMessage add(@RequestBody UserDTO userDTO);
    @CrossOrigin
    @PutMapping("/update-profile/{id}")
    ResultMessage edit(@PathVariable UUID id, @RequestBody UserEditDTO userDTO);

    @CrossOrigin
    @PutMapping("/delete-profile/{id}")
    ResultMessage<Users> deleteProfile(@PathVariable UUID userId);

    @CrossOrigin
    @GetMapping("/profile-info/{username}")
    ResultMessageObject getProfileInfo(@PathVariable String username);

}
