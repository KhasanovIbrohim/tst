package com.example.tst.payload;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EmailDetails {
    private String recipient;
    private String msgBody;
    private String subject;
    private String attachment;
}
