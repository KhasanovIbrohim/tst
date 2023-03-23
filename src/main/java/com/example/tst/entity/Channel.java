package com.example.tst.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Channel {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id", columnDefinition = "uuid", updatable = false, nullable = false)
    private UUID id = UUID.randomUUID();
    @ManyToOne
    private Users creator;
    @JoinColumn(nullable = false,unique = true)
    private String name;
    private String boi;
    @JoinColumn(nullable = false,unique = true)
    private String link;
    private Boolean isPrivate;
    private LocalDateTime createdDate;
    private Boolean isActive;
    @OneToOne
    private Groups commentGroupId;
}
