package com.edilov.springboot.service;


import com.edilov.springboot.models.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getAllUsers();
    User add(User user);
    void delete(int id);
    User update(User user);
    User getById(int id);
}