package com.example.tst.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UpdateGroupDTO {
    private String name;
    private String bio;
    private String link;
    private Boolean isPrivate;
    private String prevLink;
}
