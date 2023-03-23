package com.example.tst.repository;
import com.example.tst.entity.PersonalChat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface PersonalChatRepository extends JpaRepository<PersonalChat, UUID> {
    @Query(value = "select * from personal_chat join chat_first_users f on id = f.chat_id join chat_second_users s " +
            "on id = s.chat_id where first_user_id = ?1 and second_user_id = ?2"
            ,nativeQuery = true)
    Optional<PersonalChat> isExistUsersChat(UUID userId,UUID secondUserId);
}
