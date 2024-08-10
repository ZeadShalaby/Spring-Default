package com.deafult.project.Service.impl;

import com.deafult.project.Model.entity.Users;
import com.deafult.project.Repository.UsersRepository;
import com.deafult.project.Service.UsersService;
import com.deafult.project.Trait.ResponseTrait;
import com.deafult.project.Trait.UpdateTrait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    private UpdateTrait updateTrait;
    @Autowired
    private  ResponseTrait responseTrait;


    @Override
    public ResponseEntity<Map<String, Object>> getAllUsers() {
        List<Users> usersAll = usersRepository.findAll();
        return responseTrait.returnData("users", usersAll);
    }

    @Override
    public ResponseEntity<Map<String, Object>> getUsersById(Long id) {
        Optional<Users> user = usersRepository.findById(id);
        if (user.isPresent()) {
            return responseTrait.returnData("user", user.get());
        } else {
            return responseTrait.returnError("E001", "User not found with id: " + id);
        }
    }

    @Override
    public ResponseEntity<Map<String, Object>> AddUsers(Users users) {
        Users savedUser = usersRepository.save(users);
        return responseTrait.returnSuccessMessage("Create Account Successfully Sir : " + users.getName());
    }

    @Override
    public ResponseEntity<Map<String, Object>> UpdateUsers(Users users) {
        // todo Use the utility method to update the user
        Users existingUser = updateTrait.updateExistingUser(users);
        Users updatedUser = usersRepository.save(existingUser);
        return responseTrait.returnSuccessMessage("Edit Account Successfully Sir : " + users.getName());
    }

    @Override
    public ResponseEntity<Map<String, Object>> DeleteUsers(Long id) {
        Optional<Users> user = usersRepository.findById(id);

        if (user.isPresent()) {
            String userName = user.get().getName();  // Get the user's name before deletion
            usersRepository.deleteById(id);
            String msg = "User '" + userName + "' deleted successfully";
            return responseTrait.returnSuccessMessage(msg);
        } else {
            return responseTrait.returnError("E002", "User not found with ID: " + id);
        }
    }

    @Override
    public List<Users> SearchUsers(String name) {
        // Implement search functionality
        return null;
    }

    @Override
    public List<Users> SortingUSers(Long role) {
        // Implement sorting functionality
        return null;
    }

    @Override
    public Users RestoreIndexUsers() {
        // Implement restore index functionality
        return null;
    }

    @Override
    public String RestoreUsers(Long id) {
        // Implement restore users functionality
        return null;
    }
}
