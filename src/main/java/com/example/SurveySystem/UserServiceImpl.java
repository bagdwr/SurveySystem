package com.example.SurveySystem;

import com.example.SurveySystem.Model.Users;
import com.example.SurveySystem.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public Users getUserByLogin(String login) {
        return userRepository.getUserByLogin(login);
    }

    @Override
    public Users getUserById(Integer id) {
        return userRepository.getUserById(id);
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users saveUser(Users user) {
        Users checkUsers = getUserByLogin(user.getLogin());
        if (checkUsers == null) {
            checkUsers = userRepository.save(user);
        }
        return checkUsers;    }

    @PostConstruct
    void addFakeUsers() {
        List<Users> users = new ArrayList<>();
        users.add(new Users(null, "Daurbek_2001", "Daurbek Sakhtarov", 20, "qweqe"));
        users.add(new Users(null, "Azamat_2002", "Azamat Umbetov", 20, "qweqe"));
        users.add(new Users(null, "Maral_2002", "Maral Zhakyp", 20, "qweqe"));
        users.add(new Users(null, "Abylai_2002", "Abylai Sagymbaev", 21, "qweqe"));

        for (Users user : users) {
            saveUser(user);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users users = getUserByLogin(username);
        if(Objects.isNull(users)){
            throw new UsernameNotFoundException(String.format("User %s is not found", username));
        }
        return new org.springframework.security.core.userdetails.User(users.getLogin(), users.getPassword(), true, true, true, true, new HashSet<>());
    }
}
