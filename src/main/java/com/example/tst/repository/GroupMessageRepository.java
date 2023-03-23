package com.example.tst.repository;

import com.example.tst.entity.GroupMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface GroupMessageRepository extends JpaRepository<GroupMessage, UUID> {
}
