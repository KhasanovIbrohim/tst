package com.example.tst.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

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
public class PersonalChat   {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;

    @ManyToMany(cascade = { CascadeType.ALL },targetEntity = Users.class)
    @JoinTable(
            name = "chat_first_users",
            joinColumns = { @JoinColumn(name = "chat_id",referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "first_user_id",referencedColumnName = "id")
            }
    )
    private Set<Users> firstUsers = new HashSet<>();

    @ManyToMany(cascade = { CascadeType.ALL },targetEntity = Users.class)
    @JoinTable(
            name = "chat_second_users",
            joinColumns = { @JoinColumn(name = "chat_id",referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "second_user_id",referencedColumnName = "id")
            }
    )
    private List<Users> secondUsers;
    private Boolean isActive;
    private LocalDateTime createdDate;
}
