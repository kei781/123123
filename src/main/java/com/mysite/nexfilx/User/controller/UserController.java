package com.mysite.nexfilx.User.controller;

import com.mysite.nexfilx.User.main.NetflixUser;
import com.mysite.nexfilx.User.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {
    @Autowired
    private final UserService userService;

    @PostMapping("/signup")
    public String signup(@RequestBody NetflixUser netflixUser) {
        System.out.println("email" + netflixUser.getUseremail());
        userService.create(netflixUser);
        return "123";
    }

    @PostMapping("/login")
    public NetflixUser login(@RequestBody NetflixUser netflixUser) {
        NetflixUser loginUser = userService.login(netflixUser);
        return loginUser;
    }
}
