package com.deafult.project.Service;

import com.deafult.project.Model.entity.Users;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public interface UsersService {

    // todo return all users
    public ResponseEntity<Map<String, Object>> getAllUsers();

    // todo return users by id
    public ResponseEntity<Map<String, Object>> getUsersById(Long id);

    // todo store new users
    public ResponseEntity<Map<String, Object>> AddUsers(Users users);

    // todo update existing users
    public ResponseEntity<Map<String, Object>> UpdateUsers(Users users);

    // todo delete users by id
    public ResponseEntity<Map<String, Object>> DeleteUsers(Long id);

    // todo search for users by name
    public List<Users> SearchUsers(String name);


    // todo sort users by role
    public List<Users> SortingUSers(Long role);

    // todo RestoreIndex Users
    public Users RestoreIndexUsers();

    // todo Restore Users
    public String RestoreUsers(Long id);

}