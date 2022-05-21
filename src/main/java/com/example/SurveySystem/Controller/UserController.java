package com.example.SurveySystem.Controller;

import com.example.SurveySystem.Model.Users;
import com.example.SurveySystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity createUser(@RequestBody Users user){
        Users created = userService.saveUser(user);
        if (created!=null){
            return new ResponseEntity(created, HttpStatus.OK);
        }
        return new ResponseEntity("Error",HttpStatus.CONFLICT);
    }

    @DeleteMapping(value = "/deleteUser")
    public void deleteUser(@RequestParam(name = "id")Integer id){
        userService.deleteUser(id);
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
