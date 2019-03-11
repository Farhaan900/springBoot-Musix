package com.stackroute.userservice.service;

import com.stackroute.userservice.domain.User;

import java.util.List;

public interface UserService {
    public User saveUser(User user);
    public List<User> getUsers();
    public User getById(int id);
    public void deleteById(int id);
    public boolean updateById(User user,int id);
}
