package com.example.tst.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class SearchedUserDTO {
    private String id;
    private String firsName;
    private String secondName;
    private String userName;
}
