package com.example.tst.controller;

import com.example.tst.dto.UserDTO;
import com.example.tst.payload.ResultMessage;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping(path = "/auth")
public interface AuthController {
    @PostMapping("/login")
    ResultMessage login(@RequestBody UserDTO userDTO);

    @GetMapping("/check/{userId}/{code}")
    ResultMessage checkReliable(@PathVariable UUID userId,
                                @PathVariable String code);
}
