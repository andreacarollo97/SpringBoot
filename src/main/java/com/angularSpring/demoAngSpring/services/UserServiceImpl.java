package com.angularSpring.demoAngSpring.services;

import com.angularSpring.demoAngSpring.dto.UserDetailResponse;
import com.angularSpring.demoAngSpring.dto.UserResponse;
import com.angularSpring.demoAngSpring.mapper.UserConverter;
import com.angularSpring.demoAngSpring.models.User;
import com.angularSpring.demoAngSpring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetailResponse save(UserDetailResponse userDetailResponse) {
        User user = userConverter.convertDetailDtoToEntity(userDetailResponse);
        user = userRepository.save(user);
        return userConverter.convertEntityToDetailDto(user);
    }

    @Override
    public UserDetailResponse findById(Long id) {
        User user = userRepository.getUserById(id);
        return userConverter.convertEntityToDetailDto(user);
    }

    @Override
    public UserDetailResponse findByEmail(String email) {
        User user = userRepository.getUserByEmail(email);
        return userConverter.convertEntityToDetailDto(user);
    }

    @Override
    public List<UserResponse> findAll() {
        List<User> users = userRepository.getAllBy();
        return userConverter.entityToDto(users);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByNome(String nome) {
        return userRepository.existsByNome(nome);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
