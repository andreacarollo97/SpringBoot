package com.angularSpring.demoAngSpring.services;

import com.angularSpring.demoAngSpring.dto.UserDetailDto;
import com.angularSpring.demoAngSpring.dto.UserDto;
import com.angularSpring.demoAngSpring.mapper.UserConverter;
import com.angularSpring.demoAngSpring.models.User;
import com.angularSpring.demoAngSpring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserConverter userConverter;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public UserServiceImpl(UserConverter userConverter, UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userConverter = userConverter;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public UserDetailDto save(UserDetailDto userDetailDto) {
        User user = userConverter.convertDetailDtoToEntity(userDetailDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);
        return userConverter.convertEntityToDetailDto(user);
    }

    @Override
    public UserDetailDto findById(Long id) {
        User user = userRepository.getUserById(id);
        return userConverter.convertEntityToDetailDto(user);
    }


    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.getAllBy();
        return userConverter.entityToDto(users);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
