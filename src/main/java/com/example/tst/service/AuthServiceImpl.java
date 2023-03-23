package com.example.tst.service;

import com.example.tst.entity.Users;
import com.example.tst.payload.EmailDetails;
import com.example.tst.payload.ResultMessage;
import com.example.tst.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    final UsersRepository userRepository;
    final EmailService emailService;

    @Override
    public ResultMessage<Users> login(String email){
        Optional<Users> optionalUser= userRepository.findByEmail(email);
        Users user = optionalUser.get();
        user.setCode(generateCode());
        userRepository.save(user);
        emailService.sendSimpleMail(
                EmailDetails
                        .builder()
                        .subject("This page generated automatically please don't reply")
                        .msgBody("Please confirm your account\n\n" +
                                "Your security code: " + user.getCode())
                        .recipient(user.getEmail())
                        .build());
        Optional<Users> optionalUser2= userRepository.findByEmail(email);
        return new ResultMessage<>(true,"Email sanded",optionalUser2);
    }

    @Override
    public ResultMessage<Users> checkReliable(UUID userId, String code) {
        Optional<Users> optionalUser = userRepository.findById(userId);
        if (optionalUser.isPresent()) {
            Users user = optionalUser.get();
            if (Objects.equals(code, user.getCode())) {
                userRepository.save(user);
                Optional<Users> optionalUser2 = userRepository.findById(userId);
                return new ResultMessage(true, "user confirmed",optionalUser2);
            }
            return new ResultMessage(false, "Wrong code",optionalUser);
        }
        return new ResultMessage(false, "User not found",optionalUser);
    }

    public String generateCode() {
        StringBuilder code = new StringBuilder(10);
        for (int i = 0; i < 6; i++) {
            code.append(String.valueOf((int) (Math.random() * 10)));
        }
        return code.toString();
    }

}
