package com.example.tst.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Groups {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;
    @JoinColumn(unique = true)
    private String name;
    private LocalDateTime createdDate;
    private String bio;
    private Boolean isPrivate;
    private Boolean isActive;
    @JoinColumn(unique = true)
    private String link;
    private Boolean hasChannel;
    @ManyToOne
    private Channel channel;
    @ManyToOne
    private Users creatorUser;
    @ManyToMany(mappedBy = "groups")
    private Set<GroupMembers> groupMembersSet = new HashSet<>();
}
