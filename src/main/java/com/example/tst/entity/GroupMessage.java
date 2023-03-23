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
public class GroupMessage {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;
    @ManyToOne
    private Users fromId;
    @ManyToOne
    private Users toId;
    private Boolean isReplied;
    private String messageText;
    private Boolean isDeleted;
    private LocalDateTime sentTime;
    private Boolean isUpdated;
    @ManyToOne
    private Groups groupId;
}
