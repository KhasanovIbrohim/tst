package com.example.tst.repository;

import com.example.tst.entity.Groups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface GroupRepository extends JpaRepository<Groups, UUID> {
    @Query(value = "select * from groups where link = ?1",nativeQuery = true)
    Optional<Groups> findByLink(String link);

    @Modifying
    @Query(value = "update groups set name = ?1, link = ?2, bio = ?3, is_private = ?4 where id = ?5",nativeQuery = true)
    int updateGroup(String name,String link,String bio,Boolean isPrivate,UUID groupId);
}
