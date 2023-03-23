package com.example.tst.service;

import com.example.tst.dto.PersonalChatDto;
import com.example.tst.entity.PersonalChat;
import com.example.tst.entity.Users;
import com.example.tst.payload.ResultMessageObject;
import com.example.tst.repository.PersonalChatRepository;
import com.example.tst.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.*;

@Service
@RequiredArgsConstructor
public class PersonalChatServiceImpl implements PersonalChatService {
    final PersonalChatRepository personalChatRepository;
    final UsersRepository usersRepository;

    @Override
    public List<Optional<Users>> searchUser(UUID userId, String username) {
        return usersRepository.findByUserName(username, userId);
    }

    @Override
    public ResultMessageObject createPersonalChat(UUID firstUserId, UUID secondUserId) {
        Optional<Users> firstUser = usersRepository.findById(firstUserId);
        Optional<Users> secondUser = usersRepository.findById(secondUserId);
        if (secondUser.isEmpty()) {
            return new ResultMessageObject("user not found by first user id",false,new PersonalChatDto());
        } else if (firstUser.isEmpty()) {
            return new ResultMessageObject("user not found by second user id",false,new PersonalChatDto());
        }
        Optional<PersonalChat> existUsersChat = personalChatRepository.isExistUsersChat(firstUserId,secondUserId);
        if (existUsersChat.isPresent()){
            return new ResultMessageObject("There is chat between these users",false,dtoMaker(existUsersChat.get(),firstUserId,secondUserId));
        }
        PersonalChat save = PersonalChat.builder()
                .id(UUID.randomUUID())
                .createdDate(LocalDateTime.now())
                .firstUsers(new HashSet<>(Arrays.asList(firstUser.get())))
                .secondUsers(new ArrayList<>(Arrays.asList(secondUser.get())))
                .isActive(true)
                .build();
        PersonalChat save1 = personalChatRepository.save(save);

        return new ResultMessageObject("chat created",true,dtoMaker(save1,firstUserId,secondUserId));
    }

    @Override
    public ResultMessageObject blockChat(UUID firstUserId, UUID secondUserId) {
        Optional<PersonalChat> existUsersChat = personalChatRepository.isExistUsersChat(firstUserId, secondUserId);
        if(existUsersChat.isPresent()) {
            existUsersChat.get().setIsActive(false);
            personalChatRepository.save(existUsersChat.get());
            return new ResultMessageObject("user blocked",true,dtoMaker(existUsersChat.get(),firstUserId,secondUserId));
        }
        return new ResultMessageObject("chat not found",false,new PersonalChatDto());
    }

    @Override
    public ResultMessageObject unBlockChat(UUID firstUserId, UUID secondUserId) {
        Optional<PersonalChat> existUsersChat = personalChatRepository.isExistUsersChat(firstUserId, secondUserId);
        if(existUsersChat.isPresent()) {
            existUsersChat.get().setIsActive(true);
            personalChatRepository.save(existUsersChat.get());
            return new ResultMessageObject("user unblocked",true,dtoMaker(existUsersChat.get(),firstUserId,secondUserId));
        }
        return new ResultMessageObject("chat not found",false,new PersonalChatDto());
    }

    private PersonalChatDto dtoMaker(PersonalChat save1,UUID firstUserId,UUID secondUserId){
        return PersonalChatDto.builder()
                .chatId(save1.getId())
                .createdDate(save1.getCreatedDate())
                .fistUserId(firstUserId)
                .secondUserId(secondUserId)
                .isActive(save1.getIsActive())
                .build();
    }
}
