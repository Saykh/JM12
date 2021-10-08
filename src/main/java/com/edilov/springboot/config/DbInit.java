package com.edilov.springboot.config;

import com.edilov.springboot.models.Role;
import com.edilov.springboot.models.User;
import com.edilov.springboot.service.RoleService;
import com.edilov.springboot.service.UserService;
import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.Set;

@Component
public class DbInit {

    private final UserService userService;
    private final RoleService roleService;


    public DbInit(UserService userService, RoleService roleService){
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void doInit(){
        Role role1 = new Role("ROLE_ADMIN");
        Role role2 = new Role("ROLE_USER");

        roleService.save(role1);
        roleService.save(role2);

        Set<Role> userRole = new HashSet<>();
        userRole.add(role2);

        Set<Role> AdminAndUserRole = new HashSet<>();
        AdminAndUserRole.add(role1);
        AdminAndUserRole.add(role2);

        User user1 = new User();
        user1.setName("Muslim");
        user1.setLastName("Isaev");
        user1.setAge(26);
        user1.setLogin("isaev_mv@mail.ru");
        user1.setPassword("12345");
        user1.setRoles(userRole);
        userService.add(user1);


        User user2 = new User();
        user2.setName("Saykhan");
        user2.setLastName("Edilov");
        user2.setAge(27);
        user2.setLogin("edilov_st@mail.ru");
        user2.setPassword("12345");
        user2.setRoles(AdminAndUserRole);
        userService.add(user2);


    }
}