package com.angularSpring.demoAngSpring.services;

import com.angularSpring.demoAngSpring.dto.UserDetailDto;
import com.angularSpring.demoAngSpring.dto.UserDto;

import java.util.List;

public interface UserService {

    UserDetailDto save(UserDetailDto userDetailDto);

    UserDetailDto findById(Long id);

    UserDetailDto findByEmail(String email);

    List<UserDto> findAll();

    void delete(Long id);
}
