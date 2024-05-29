package com.gdsc.projectno1.controller;

import com.gdsc.projectno1.dto.request.UserDto;
import com.gdsc.projectno1.entity.User;
import com.gdsc.projectno1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    public UserController(@RequestBody UserService userService) {
        this.userService = userService;
    }

    UserService userService;

    @GetMapping("/showAll")
    public List<User> getAll(){
        return userService.showAllUsers();
    }

    @PostMapping("/signUp")
    public void signUp(@RequestBody UserDto userDto){
        userService.signUp(userDto);
    }
    @GetMapping("/signIn")
    public User signIn(@RequestBody UserDto userDto){
        return userService.signIn(userDto);
    }
}
