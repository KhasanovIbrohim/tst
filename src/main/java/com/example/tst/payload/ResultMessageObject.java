package com.example.tst.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResultMessageObject {
    private String message;
    private Boolean isSucsess;
    private Object object;
}
