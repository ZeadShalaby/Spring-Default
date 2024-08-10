package com.deafult.project.Trait;

import com.deafult.project.Model.entity.Users;
import com.deafult.project.Repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateTrait {

    @Autowired
    private UsersRepository usersRepository;

    public Users updateExistingUser(Users users) {

        // todo Fetch the existing user from the database
        Users existingUser = usersRepository.findById(Long.valueOf(users.getId()))
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + users.getId()));

        // todo Update the necessary fields
        existingUser.setId(users.getId());
        existingUser.setName(users.getName());
        existingUser.setEmail(users.getEmail());
        existingUser.setPassword(users.getPassword());
        existingUser.setRole(users.getRole());
        existingUser.setGender(users.getGender());
        existingUser.setBirthday(users.getBirthday());
        existingUser.setUpdatedAt(users.getUpdatedAt());

        return existingUser;
    }

}
