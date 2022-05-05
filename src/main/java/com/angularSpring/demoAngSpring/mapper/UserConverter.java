package com.angularSpring.demoAngSpring.mapper;


import com.angularSpring.demoAngSpring.dto.UserDetailResponse;
import com.angularSpring.demoAngSpring.dto.UserResponse;
import com.angularSpring.demoAngSpring.models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserConverter {
    public UserResponse convertEntityToDto(User user){
        UserResponse userResponse = new UserResponse();
        userResponse.setId(user.getId());
        userResponse.setNome(user.getNome());
        userResponse.setCognome(user.getCognome());
        userResponse.setEmail(user.getEmail());
        return userResponse;
    }

    public User convertDtoToEntity(UserResponse userResponse){
        User user = new User();
        user.setId(userResponse.getId());
        user.setNome(userResponse.getNome());
        user.setCognome(userResponse.getCognome());
        user.setEmail(userResponse.getEmail());
        return user;
    }

    public List<UserResponse> entityToDto(List<User> users) {
        List<UserResponse> userResponses = new ArrayList<>();
        for (User user : users) {
            UserResponse response = new UserResponse();
            response.setId(user.getId());
            response.setNome(user.getNome());
            response.setCognome(user.getCognome());
            response.setEmail(user.getEmail());
            userResponses.add(response);
        }
        return userResponses;
    }

    public UserDetailResponse convertEntityToDetailDto(User user){
        UserDetailResponse userDetailResponse = new UserDetailResponse();
        userDetailResponse.setId(user.getId());
        userDetailResponse.setNome(user.getNome());
        userDetailResponse.setCognome(user.getCognome());
        userDetailResponse.setEmail(user.getEmail());
        userDetailResponse.setPassword(user.getPassword());
        return userDetailResponse;
    }

    public User convertDetailDtoToEntity(UserDetailResponse userDetailResponse){
        User user = new User();
        user.setId(userDetailResponse.getId());
        user.setNome(userDetailResponse.getNome());
        user.setCognome(userDetailResponse.getCognome());
        user.setEmail(userDetailResponse.getEmail());
        user.setPassword(userDetailResponse.getPassword());
        return user;
    }

    public List<UserDetailResponse> entityToDetailDto(List<User> users) {
        List<UserDetailResponse> userDetailResponses = new ArrayList<>();
        for (User user : users) {
            UserDetailResponse response = new UserDetailResponse();
            response.setId(user.getId());
            response.setNome(user.getNome());
            response.setCognome(user.getCognome());
            response.setEmail(user.getEmail());
            response.setPassword(user.getPassword());
            userDetailResponses.add(response);
        }
        return userDetailResponses;
    }


}
