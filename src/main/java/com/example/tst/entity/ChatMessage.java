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
public class ChatMessage {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id;
    @ManyToOne
    private Users userId;
    private String messageText;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "chat_message_personal_chat",
            joinColumns = { @JoinColumn(name = "chat_message",referencedColumnName = "id")},
            inverseJoinColumns = {
                    @JoinColumn(name = "personal_chat",referencedColumnName = "id")
            }
    )
    private List<PersonalChat> chatId;
    private LocalDateTime sentTime;
    private Boolean isDeleted;
}
