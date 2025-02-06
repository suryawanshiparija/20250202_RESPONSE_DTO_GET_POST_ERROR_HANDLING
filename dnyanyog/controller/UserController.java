package org.dnyanyog.controller;

import org.dnyanyog.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService = new UserService();

    @GetMapping("/name/{userId}")
    public String getUserName(@PathVariable int userId) {
        return userService.getUserName(userId);
    }
}
