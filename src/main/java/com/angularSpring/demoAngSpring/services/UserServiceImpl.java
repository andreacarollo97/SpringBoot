package com.angularSpring.demoAngSpring.services;

import com.angularSpring.demoAngSpring.dto.UserDetailDto;
import com.angularSpring.demoAngSpring.dto.UserDto;
import com.angularSpring.demoAngSpring.mapper.UserConverter;
import com.angularSpring.demoAngSpring.models.User;
import com.angularSpring.demoAngSpring.repository.UserRepository;
import com.angularSpring.demoAngSpring.security.UserLogged;
import org.springframework.security.core.context.SecurityContextHolder;
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
    public void save(UserDetailDto userDetailDto) {
        UserLogged userLogged = (UserLogged) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userLogged.getRuolo().equals("ROLE_ADMIN") && (userDetailDto.getRuolo().equals("ROLE_SUPER"))){
          throw new RuntimeException("Non hai i permessi per eseguire quest'operazione");
        }
        User user = userConverter.convertDetailDtoToEntity(userDetailDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user = userRepository.save(user);
        userConverter.convertEntityToDetailDto(user);

    }

    @Override
    public UserDto findById(Long id) {
        User user = userRepository.getUserById(id);
        return userConverter.convertEntityToDto(user);
    }

    @Override
    public List<UserDto> findAll() {
        List<User> users = userRepository.getAllBy();
        return userConverter.entityToDto(users);
    }
    @Override
    public void delete(Long id) {
        UserLogged userLogged = (UserLogged) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userLogged.getRuolo().equals("ROLE_ADMIN")){
            userRepository.deleteByIdAndRuolo(id,"ROLE_USER");
        } else if (userLogged.getRuolo().equals("ROLE_SUPER")) {
            userRepository.deleteByIdAndRuolo(id,"ROLE_ADMIN");
        }
        else {
            throw new RuntimeException("Non hai i permessi per eseguire quest'operazione");
        }
    }

    @Override
    public List<UserDto> findAllByRuoloNot(String ruolo) {
        List<User> users = userRepository.getAllByRuoloNot(ruolo);
        return userConverter.entityToDto(users);
    }
}
