package org.example.medchatapi.services;

import lombok.Setter;
import org.example.medchatapi.dto.User;
import org.springframework.stereotype.Component;

@Component
public class LoginUser implements Command<String> {
    private final UserService userService;
    @Setter
    private User user;

    public LoginUser(UserService userService){
        this.userService = userService;
    }

    @Override
    public String execute() {
        return userService.validateLogin(user);
    }
}
