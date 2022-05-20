package com.example.SurveySystem;

import com.example.SurveySystem.Model.Users;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;


public interface UserService extends UserDetailsService {
    Users getUserByLogin(String login);

    Users getUserById(Integer id);

    List<Users> getAllUsers();

    Users saveUser(Users user);

}
