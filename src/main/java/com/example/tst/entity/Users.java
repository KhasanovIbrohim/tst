package com.example.tst.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class Users {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;
    @JoinColumn(nullable = false)
    private String firstName;
    private String secondName;
    @JoinColumn(unique = true)
    private String username;
    @JoinColumn(unique = true)
    private String email;
    private String bio;
    private Boolean isDeleted;
    private Boolean isOnline;
    private LocalDateTime createdDate;
    private LocalDateTime lastOnlineTime;
    private String code;
    @JsonIgnore
    @ManyToMany(mappedBy = "firstUsers")
    private Set<PersonalChat> personalChats;
    @JsonIgnore
    @ManyToMany(mappedBy = "secondUsers")
    private Set<PersonalChat> personalChatsOfSecondUser;
    @JsonIgnore
    @ManyToMany(mappedBy ="userId")
    private Set<GroupMembers> groupMembers = new HashSet<>();
}
