package com.thoughtworks.capacity.gtb.mvc.dao.dto;

import com.thoughtworks.capacity.gtb.mvc.dao.User;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegisterUserRequest {
    @NotBlank
    @Size(min=5, max=12, message = "用户名不合法")
    private String username;

    @NotBlank
    @Size(min=5, max=12, message = "密码不合法")
    @Pattern(regexp = "^[0-9a-zA-Z_]{1,}$", message = "密码不合法")
    private String password;

    @NotBlank
    @Email(message = "邮箱不合法")
    private String mail;

    public RegisterUserRequest(String username, String password, String mail) {
        this.username = username;
        this.password = password;
        this.mail = mail;
    }

    public User createUser() {
        User user = new User();
        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setMail(this.mail);

        return user;
    }
}
