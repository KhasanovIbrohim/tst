package com.example.tst.service;

import com.example.tst.dto.UserDTO;
import com.example.tst.dto.UserEditDTO;
import com.example.tst.entity.Users;
import com.example.tst.payload.ResultMessage;
import com.example.tst.payload.ResultMessageObject;
import com.example.tst.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {
    final UsersRepository usersRepository;

    @Override
    public ResultMessage<Users> add(UserDTO userDTO) {
        Optional<Users> byId;
        Optional<Users> optionalUser = usersRepository.findByEmail(userDTO.getEmail());
        if (optionalUser.isPresent()) {
            return new ResultMessage<>(false, "this email already exists", optionalUser);
        }
        Optional<Users> byUsername = usersRepository.findByUsername(userDTO.getUserName());
        if (byUsername.isPresent()) {
            return new ResultMessage<>(false, "this userName already exists", byUsername);
        } else {
            Users users = Users.builder()
                    .id(UUID.randomUUID())
                    .email(userDTO.getEmail())
                    .firstName(userDTO.getFirstName())
                    .secondName(userDTO.getSecondName())
                    .isDeleted(false)
                    .username(userDTO.getUserName())
                    .createdDate(LocalDateTime.now())
                    .build();
            byId = usersRepository.findById(usersRepository.save(users).getId());
        }
        return new ResultMessage<>(true, "succsessfully verified", byId);
    }
    @Override
    public ResultMessage<Users> edit(UUID id, UserEditDTO userDTO) {
        List<Users> allUsers = usersRepository.findAll();
        Optional<Users> usersOptional = usersRepository.findById(id);
        if (usersOptional.isPresent()) {
            for (Users allUser : allUsers) {
                if (Objects.equals(allUser.getUsername(), userDTO.getUserName()) && !Objects.equals(allUser.getId(), id)) {
                    return new ResultMessage<>(false, "User already exist with username: " + userDTO.getUserName(), usersOptional);
                }
            }
            Users users = usersOptional.get();
            users.setUsername(userDTO.getUserName());
            users.setFirstName(userDTO.getFirstName());
            users.setSecondName(userDTO.getSecondName());
            return new ResultMessage<>(true, "Successfully edited", usersOptional);
        }
        return new ResultMessage<>(false, "User not fount with id " + id, usersOptional);
    }

    @Override
    public ResultMessage<Users> deleteProfile(UUID userId) {
        Optional<Users> byId = usersRepository.findById(userId);
        if (byId.isPresent()){
            byId.get().setIsDeleted(true);
            Users save = usersRepository.save(byId.get());
            return new ResultMessage<>(true,"Profile deleted",byId);
        }
        return new ResultMessage<>(false,"user not found",byId);
    }
    @Override
    public ResultMessageObject getProfileInfo(String username){
        Optional<Users> userById = usersRepository.findByUsername(username);
        if (userById.isPresent()){
         UserDTO userDTO = UserDTO.builder()
                    .userName(userById.get().getUsername())
                    .secondName(userById.get().getSecondName())
                    .email(userById.get().getEmail())
                    .firstName(userById.get().getFirstName())
                    .build();
            return new ResultMessageObject("User found",true,userDTO);
        }
        return new ResultMessageObject("User not found",false,new UserDTO());
    }
}
