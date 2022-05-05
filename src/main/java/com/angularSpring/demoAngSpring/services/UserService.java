package com.angularSpring.demoAngSpring.services;

import com.angularSpring.demoAngSpring.dto.UserDetailResponse;
import com.angularSpring.demoAngSpring.dto.UserResponse;
import com.angularSpring.demoAngSpring.models.User;

import java.util.List;

public interface UserService {

    UserDetailResponse save(UserDetailResponse userDetailResponse);

    UserDetailResponse findById(Long id);

    List<UserResponse> findAll();

    void delete(Long id);
}
