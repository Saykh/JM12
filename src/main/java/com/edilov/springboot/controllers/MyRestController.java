package com.edilov.springboot.controllers;

import com.edilov.springboot.models.Role;
import com.edilov.springboot.models.User;
import com.edilov.springboot.service.RoleService;
import com.edilov.springboot.service.UserService;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRestController {

    private final UserService userService;
    private final RoleService roleService;


    public MyRestController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/admin")
    public List<User> getAllUsers(){
        return userService.getAllUsers();

    }

    @PostMapping("/admin")
    public User addUser(@RequestBody User user) {
        userService.add(user);
        return user;
    }

    @GetMapping("/admin/{id}")
    public User getUserById(@PathVariable int id) {
        return userService.getById(id);
    }

    @GetMapping("/admin/roles")
    public List<Role> getAllRoles() {
        List<Role> roles = new ArrayList<>(roleService.getAllRoles());
        return roles;
    }

    @PutMapping("/admin")
    public User updateUser(@RequestBody User user) {
        userService.update(user);
        return user;

    }

    @DeleteMapping("/admin/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.delete(id);
        return "User with ID = " + id + " was deleted";
    }
}