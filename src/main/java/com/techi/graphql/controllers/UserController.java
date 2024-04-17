package com.techi.graphql.controllers;

import com.techi.graphql.entities.User;
import com.techi.graphql.services.UserService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // create User
    @MutationMapping
    public User createUser(@Argument String name, @Argument String phone, @Argument String email, @Argument String password) {
        return userService.createUser(new User(name, email, phone, password));
    }

    // get all users
    @QueryMapping
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    // get single user
    @QueryMapping(name = "getUser")
    public User getSingleUser(@Argument int userId){
        return userService.getSingleUser(userId);
    }

    @MutationMapping
    public Boolean deleteUser(@Argument int userId){
        return userService.deleteUser(userId);
    }
}
