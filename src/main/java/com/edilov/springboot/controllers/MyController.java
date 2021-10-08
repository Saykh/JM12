package com.edilov.springboot.controllers;

import com.edilov.springboot.service.RoleService;
import com.edilov.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.security.Principal;

@Controller
public class MyController {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public MyController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/admin")
    public String index(Model model, Principal principal){
        model.addAttribute("uPrincipal", userService.loadUserByUsername(principal.getName()));
        model.addAttribute("AllRoles", roleService.getAllRoles());
        return "admin";
    }

    @GetMapping("/user")
    public String getUserPage(Principal principal, Model model) {
        model.addAttribute("uPrincipal",userService.loadUserByUsername(principal.getName()));
        return "user";
    }
}