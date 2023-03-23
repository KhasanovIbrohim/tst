package com.example.tst.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GroupMembers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "users_in_group",
            joinColumns = { @JoinColumn(name = "group_members_id",referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "user_id",referencedColumnName = "id")
            }
    )
    private Set<Users> userId = new HashSet<>();
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "groups_with_user",
            joinColumns = { @JoinColumn(name = "group_members_id",referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "group_id",referencedColumnName = "id")
            }
    )
    private Set<Groups> groups = new HashSet<>();
    private Boolean isInGroup;
    private LocalDateTime joinedTime;
}
