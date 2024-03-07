package org.example.medchatapi.services;

import lombok.Setter;
import org.springframework.stereotype.Component;
import org.example.medchatapi.dto.User;

@Component
public class RegisterUser implements Command<String> {
    private final UserService userService;
    @Setter
    private User user;

    public RegisterUser(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute() {
        String response = userService.validateUser(user);
        if(response.equals("OK")) {
            return userService.saveUser(user);
        }
        else {
            return response;
        }
    }
}
