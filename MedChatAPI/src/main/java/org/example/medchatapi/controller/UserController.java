package org.example.medchatapi.controller;

import org.example.medchatapi.dto.User;
import org.example.medchatapi.repository.UserRepository;
import org.example.medchatapi.services.LoginUser;
import org.example.medchatapi.services.RegisterUser;
import org.example.medchatapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    private final RegisterUser registerUser;
    private final LoginUser loginUser;

    @Autowired
    public UserController(RegisterUser registerUser, LoginUser loginUser) {
        this.registerUser = registerUser;
        this.loginUser = loginUser;
    }

    @PostMapping("/medChat/register")
    public String registerUser(@RequestBody User user) {
       this.registerUser.setUser(user);
       return registerUser.execute();
    }

    @PostMapping("/medChat/login")
    public String loginUser(@RequestBody User user) {
        this.loginUser.setUser(user);
        return loginUser.execute();
    }
}
