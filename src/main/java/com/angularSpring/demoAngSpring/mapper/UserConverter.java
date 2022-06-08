package com.angularSpring.demoAngSpring.mapper;


import com.angularSpring.demoAngSpring.dto.UserDetailDto;
import com.angularSpring.demoAngSpring.dto.UserDto;
import com.angularSpring.demoAngSpring.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserConverter {

    public User convertDtoToEntity(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setNome(userDto.getNome());
        user.setCognome(userDto.getCognome());
        user.setEmail(userDto.getEmail());
        user.setRuolo(userDto.getRuolo());
        return user;
    }

    public List<UserDto> entityToDto(List<User> users) {
        List<UserDto> userResponse = new ArrayList<>();
        for (User user : users) {
            UserDto response = new UserDto();
            response.setId(user.getId());
            response.setNome(user.getNome());
            response.setCognome(user.getCognome());
            response.setEmail(user.getEmail());
            response.setRuolo(user.getRuolo());
            userResponse.add(response);
        }
        return userResponse;
    }

    public UserDetailDto convertEntityToDetailDto(User user){
        UserDetailDto userDetailDto = new UserDetailDto();
        userDetailDto.setId(user.getId());
        userDetailDto.setNome(user.getNome());
        userDetailDto.setCognome(user.getCognome());
        userDetailDto.setEmail(user.getEmail());
        userDetailDto.setPassword(user.getPassword());
        userDetailDto.setRuolo(user.getRuolo());
        return userDetailDto;
    }

    public User convertDetailDtoToEntity(UserDetailDto userDetailDto){
        User user = new User();
        user.setId(userDetailDto.getId());
        user.setNome(userDetailDto.getNome());
        user.setCognome(userDetailDto.getCognome());
        user.setEmail(userDetailDto.getEmail());
        user.setPassword(userDetailDto.getPassword());
        user.setRuolo(userDetailDto.getRuolo());
        return user;
    }

}
