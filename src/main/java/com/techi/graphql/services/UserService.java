package com.techi.graphql.services;

import com.techi.graphql.entities.User;
import com.techi.graphql.helper.ExceptionHelper;
import com.techi.graphql.repo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    // Create user
    public User createUser(User user) {
        return userRepo.save(user);
    }

    // getting all user
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    // getting single user
    public User getSingleUser(int id) {
        return userRepo.findById(id).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
    }

    // deleting user
    public boolean deleteUser(int id) {
        User user = userRepo.findById(id).orElseThrow(ExceptionHelper::throwResourceNotFoundException);
        userRepo.delete(user);
        return true;
    }
}
