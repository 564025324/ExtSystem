package com.extSystem.model;

import lombok.Data;
import lombok.Getter;

@Data
public class User {
    private Integer id;

    private String username;

    private String password;

    private String mobile;

    private String email;

    private String sex;

    private String nickname;

}