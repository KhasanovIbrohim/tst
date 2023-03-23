package com.example.tst.repository;

import com.example.tst.entity.ChannelSubscribers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChannelSubscribersRepository extends JpaRepository<ChannelSubscribers, UUID> {
}
