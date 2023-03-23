package com.example.tst.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDevice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String product;
    private String platform;
    private String appName;
    private Boolean isActive;
    @ManyToOne
    private Users user;
    private String appCodeName;
    private String userAgent;
    private String securityCode;
}
