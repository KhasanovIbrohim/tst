package com.example.tst.repository;
import com.example.tst.entity.ChannelPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ChannelPostRepository extends JpaRepository<ChannelPost, UUID> {
}
