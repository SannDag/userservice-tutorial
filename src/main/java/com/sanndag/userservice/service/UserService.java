package com.sanndag.userservice.service;

import com.sanndag.userservice.domain.User;
import com.sanndag.userservice.domain.Role;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username, String roleName);
    User getUser(String username);
    List<User> getUsers();



}
