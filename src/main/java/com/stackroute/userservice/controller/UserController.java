package com.stackroute.userservice.controller;

import com.stackroute.userservice.domain.User;
import com.stackroute.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1")
public class UserController {

    private UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")

    public ResponseEntity<User> saveUser(@RequestBody User user){

        User savedUser = userService.saveUser(user);
        return new ResponseEntity<User>(savedUser, HttpStatus.OK);
    }

    @GetMapping("/users")

    public ResponseEntity<List<User>> getUsers(){

        List<User> users = userService.getUsers();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);


    }

    @GetMapping("/user/{id}")

    public ResponseEntity<User> getById(@PathVariable int id){
        User user = userService.getById(id);
        return new ResponseEntity<User>(user,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        userService.deleteById(id);
        return "Data deleted";
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody User user, @PathVariable int id) {

        if (userService.updateById(user,id)){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
