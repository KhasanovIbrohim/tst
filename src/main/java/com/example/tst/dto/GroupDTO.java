package com.example.tst.dto;

import lombok.*;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GroupDTO {
    private String name;
    private String link;
    private Boolean isPrivate;
    private UUID creatorId;
    private String bio;
}
