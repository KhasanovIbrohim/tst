package com.example.tst.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ChannelSubscribers {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "subscribers",
            joinColumns = { @JoinColumn(name = "channel_subscribers_id",referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "user_id",referencedColumnName = "id"),
            }
    )
    private List<Users> userId;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "channel_user",
            joinColumns = { @JoinColumn(name = "channel_subscribers_id",referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "channel_id",referencedColumnName = "id"),
            }
    )
    private List<Channel> channels;
    private Boolean isAdmin;
    private Boolean isInChannel;
    private LocalDateTime joinedTime;
}
