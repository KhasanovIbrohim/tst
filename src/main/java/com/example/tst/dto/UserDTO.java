package com.example.tst.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDTO {
    private String userName;
    private String firstName;
    private String secondName;
    private String email;
}
