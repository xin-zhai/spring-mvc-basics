package com.thoughtworks.capacity.gtb.mvc.dao.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserLoginRequest {
    @NotBlank
    @Size(min=5, max=12, message = "用户名不合法")
    private String username;

    @NotBlank
    @Size(min=5, max=12, message = "密码不合法")
    @Pattern(regexp = "^[0-9a-zA-Z_]{1,}$", message = "密码不合法")
    private String password;

    public UserLoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
