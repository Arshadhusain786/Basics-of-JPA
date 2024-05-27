package com.sample.jpa_demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String addUser(User user){

        userRepository.save(user);
        return "User added";
    }

    public List<User> getUsers(){
        return userRepository.findAll();
    }

    public User getUser(int id){
        return userRepository.findById(id).get();
    }
    public String deleteUser(int id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return "User deleted successfully!";
        } else {
            return "User not found!";
        }
    }
    public String deleteAllUsers() {
        userRepository.deleteAll();
        return "All users deleted successfully!";
    }
    public String updateUserName(int id, String name) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(name);
            userRepository.save(user);
            return "User name updated successfully!";
        } else {
            return "User not found!";
        }
    }

    // delete all the users

    // delete a user by userId

    // update the name of a user with a particular userId
}