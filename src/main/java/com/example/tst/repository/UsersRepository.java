package com.example.tst.repository;

import com.example.tst.dto.SearchedUserDTO;
import com.example.tst.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UsersRepository extends JpaRepository<Users, UUID> {
    @Query(value = "select * from users where email = ?1 ",nativeQuery = true)
    Optional<Users> findByEmail(String email);

    @Query(value = "select * from users where username = ?1",nativeQuery = true)
    Optional<Users> findByUsername(String userName);

    @Query(value = "select * from users where username Ilike ?1% and is_deleted = false and id <> ?2",nativeQuery = true)
    List<Optional<Users>> findByUserName(String username,UUID userId);

    @Query(value = "select * from users where id = ?1",nativeQuery = true)
    List<Users> findByUserId(UUID userId);
}
