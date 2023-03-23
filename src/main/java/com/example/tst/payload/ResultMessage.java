package com.example.tst.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResultMessage<T> {
    Boolean success;
    String message;
    Optional<T> object;
}
