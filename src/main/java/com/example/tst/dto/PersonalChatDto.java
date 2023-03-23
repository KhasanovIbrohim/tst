package com.example.tst.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PersonalChatDto {
    private UUID fistUserId;
    private UUID secondUserId;
    private UUID chatId;
    private Boolean isActive;
    private LocalDateTime createdDate;
}
