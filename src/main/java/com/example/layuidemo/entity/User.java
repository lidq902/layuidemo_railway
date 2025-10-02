package com.example.layuidemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long userid;
    private String username;
    private String realname;
    private String password;
    private String email;
    private String rolename;

}
