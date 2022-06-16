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
    public UserDetailDto save(UserDetailDto userDetailDto) {
        UserLogged userLogged = (UserLogged) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userLogged.getRuolo().equals("ADMIN") && !userDetailDto.getRuolo().equals("USER") && (!userLogged.getId().equals(userDetailDto.getId()))){
          throw new RuntimeException("Non hai i permessi per eseguire quest'operazione");
        }
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
        UserLogged userLogged = (UserLogged) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (userLogged.getRuolo().equals("ADMIN")){
            userRepository.deleteByIdAndRuolo(id,"USER");
        } else if (userLogged.getRuolo().equals("SUPER")) {
            userRepository.deleteByIdAndRuolo(id,"ADMIN");
        }
        else {
            throw new RuntimeException("Non hai i permessi per eseguire quest'operazione");
        }
    }
}
