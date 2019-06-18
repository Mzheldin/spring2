package com.geekbrains.spring2.service.model;

import com.geekbrains.spring2.persist.model.Role;
import com.geekbrains.spring2.persist.model.User;
import lombok.Data;

import java.util.Set;

@Data
public class SystemUser {

    private Long id;

    private String userName;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private Set<Role> roles;

    public SystemUser() {

    }

    public SystemUser(String userName, String password, String firstName,
                      String lastName, String email, Set<Role> roles) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roles = roles;
    }

    public SystemUser(User user) {
        this.id = user.getId();
        this.userName = user.getUserName();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.roles = user.getRoles();
    }
}
