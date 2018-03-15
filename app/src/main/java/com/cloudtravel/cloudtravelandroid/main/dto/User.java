package com.cloudtravel.cloudtravelandroid.main.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private Integer userId;

    private String userName;

    private String password;

    private String email;

}