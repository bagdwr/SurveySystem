package com.example.SurveySystem.Controller;

import com.example.SurveySystem.Model.Users;
import com.example.SurveySystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/getAllUsers")
    public List<Users> getUsers(){
        return userService.getAllUsers();
    }

    @PostMapping(value = "/createUser")
    public Users createUser(@RequestBody Users user){
        System.out.println(user);
        return userService.saveUser(user);
    }

    @PostMapping(value = "/login")
    public @ResponseBody
    Users getAuthUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if(auth==null){
            return null;
        }

        Object principal = auth.getPrincipal();
        Users users = (principal instanceof Users)? (Users) principal : null;
        return Objects.nonNull(users) ? this.userService.getUserByLogin(users.getLogin()): null;
    }
}
