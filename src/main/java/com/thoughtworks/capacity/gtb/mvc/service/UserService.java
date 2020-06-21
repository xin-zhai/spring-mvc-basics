package com.thoughtworks.capacity.gtb.mvc.service;

import com.thoughtworks.capacity.gtb.mvc.dao.User;
import com.thoughtworks.capacity.gtb.mvc.dao.dto.UserLoginResponse;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    private Map<Integer, User> userMap = new HashMap<>();

    public UserService() {
        userMap.put(1, new User(1, "zhaixin", "123A_", "123456@thoughtworks.com"));
    }

    public UserLoginResponse userLogin(String username, String password) {
        for (Map.Entry<Integer, User> entry : userMap.entrySet()) {
            if (entry.getValue().getUsername().equals(username) && entry.getValue().getPassword().equals(password)) {
                UserLoginResponse userLoginResponse = new UserLoginResponse(entry.getValue().getId(),entry.getValue().getUsername(),entry.getValue().getMail());
                return userLoginResponse;
            }
        }
        return null;
    }

    public String registerUser(User user) {
        for(Map.Entry<Integer, User> entry : userMap.entrySet()) {
            if(entry.getValue().getUsername().equals(user.getUsername())) {
                return "exist";
            }
        }
        int userId = userMap.size() + 1;
        user.setId(userId);
        userMap.put(userId, user);

        return "not exist";
    }


}
