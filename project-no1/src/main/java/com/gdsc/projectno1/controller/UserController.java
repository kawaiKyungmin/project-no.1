package com.gdsc.projectno1.controller;

import com.gdsc.projectno1.dto.request.UserDto;
import com.gdsc.projectno1.entity.User;
import com.gdsc.projectno1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    UserService userService;

    @GetMapping("/show/all/users")
    public List<User> getAll(){
        return userService.showAllUsers();
    }
    @PostMapping("/signUp")
    public User signUp(UserDto userDto){
        return userService.signUp(userDto);
    }
    @GetMapping("/signIn")
    public User signIn(UserDto userDto){
        return userService.signIn(userDto);
    }
}