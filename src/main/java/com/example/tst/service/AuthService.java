package com.example.tst.service;



import com.example.tst.entity.Users;
import com.example.tst.payload.ResultMessage;

import java.util.UUID;

public interface AuthService {
    ResultMessage<Users> login(String email);

    ResultMessage<Users> checkReliable(UUID userId,
                                       String code);
}
