package com.deafult.project.Controller;


import com.deafult.project.Model.entity.Users;
import com.deafult.project.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UsersService usersService;

    // todo * get all data for users *
    @GetMapping("")
    public ResponseEntity<Map<String, Object>> getAllUsers() {
        return usersService.getAllUsers();
    }

    // todo * get data for user by id *
    @GetMapping("/get-user/{id}")
    public ResponseEntity<Map<String, Object>> getUser(@PathVariable Long id) {
        return usersService.getUsersById(id);
    }

    // todo Store New users
    @PostMapping("/add-users")
    public ResponseEntity<Map<String, Object>> Store(@RequestBody Users users){
        return usersService.AddUsers(users);
    }

    // todo Update users
    @PutMapping("/update-users")
    public ResponseEntity<Map<String, Object>> UpdateUsers(@RequestBody Users users){
        return usersService.UpdateUsers(users);
    }

    // todo Delete users
    @DeleteMapping("/delete-users/{id}")
    public ResponseEntity<Map<String, Object>> DeleteUsers(@PathVariable Long id){
        return usersService.DeleteUsers(id);
    }
}
