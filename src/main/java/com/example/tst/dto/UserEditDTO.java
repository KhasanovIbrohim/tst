package com.example.tst.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserEditDTO {
    private String userName;
    private String firstName;
    private String secondName;
}
