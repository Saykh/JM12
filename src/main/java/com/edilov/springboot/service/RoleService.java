package com.edilov.springboot.service;

import com.edilov.springboot.models.Role;
import java.util.Set;

public interface RoleService {
    public void save(Role role);
    public Set<Role> getAllRoles();
    public Role getRoleById(Long id);
}
