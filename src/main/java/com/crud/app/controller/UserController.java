package com.crud.app.controller;


import com.crud.app.entities.User;
import com.crud.app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "auth")
public class UserController {

    @Autowired
    private UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "register")
    public User register(@RequestBody User user){
        return this.userService.register(user);
    }


    @PostMapping(path = "login")
    public String login(@RequestBody String email, @RequestBody String password) throws Exception {
        return this.userService.login(email, password);
    }



}
