package com.angularSpring.demoAngSpring.services;

import com.angularSpring.demoAngSpring.dto.UserDetailDto;
import com.angularSpring.demoAngSpring.dto.UserDto;

import java.util.List;

public interface UserService {

    void save(UserDetailDto userDetailDto);

    UserDto findById(Long id);

    List<UserDto> findAll();

    void delete(Long id);

    List<UserDto> findAllByRuoloNot(String ruolo);

}
