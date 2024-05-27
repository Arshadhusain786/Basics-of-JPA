package com.sample.jpa_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController
{

    @Autowired
    UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody User user)
    {

        return userService.addUser(user);
    }

    @GetMapping("/getUsers")
    public List<User> getAllUsers()
    {

        return userService.getUsers();
    }

    @GetMapping("/getUser")
    public User getUser(@RequestParam("id") int id)
    {
        return userService.getUser(id);
    }
    @DeleteMapping("/delete")
    public String deleteUser(@RequestParam("id") int id)
    {
        return userService.deleteUser(id);
    }
    @DeleteMapping("/deleteAll")
    public String deleteAllUsers() {
        return userService.deleteAllUsers();
    }
    @PutMapping("/update")
    public String updateUserName(@RequestParam("id") int id, @RequestParam("name") String name) {
        return userService.updateUserName(id, name);
    }
}