package com.example.tst.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChannelPost {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;
    private String postText;
    @ManyToOne
    private Users from;
    private LocalDateTime sentDate;
    private Boolean isDeleted;
    private Boolean isUpdated;
    private Integer views;
    @ManyToOne
    @JoinColumn(nullable = false)
    private Channel channel;
}
