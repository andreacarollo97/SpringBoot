package com.angularSpring.demoAngSpring.services;

import com.angularSpring.demoAngSpring.models.User;

import java.util.List;

public interface UserService {

    User save(User user);

    User findById(Long id);

    List<User> findAll();

    void delete(Long id);
}
