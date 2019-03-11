package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    @Autowired
    public UserRepository getUserRepository() {
        return userRepository;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user){

        User savedUser = userRepository.save(user);

        return savedUser;
    }

    public List<User> getUsers(){

        return (List<User>)userRepository.findAll();

    }

    public User getById(int id) {

        Optional<User> user_id = userRepository.findById(id);

        if (!user_id.isPresent())
            return null;

        return user_id.get();


    }


    public void deleteById(int id) {
        userRepository.deleteById(id);

        }


    public boolean updateById(User user,int id) {
        Optional<User> userOptional = userRepository.findById(id);

        if (!userOptional.isPresent())
            return false;
//            return ResponseEntity.notFound().build();

        user.setId(id);

        userRepository.save(user);
        return true;
    }
}
