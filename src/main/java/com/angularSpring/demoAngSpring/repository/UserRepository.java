package com.angularSpring.demoAngSpring.repository;

import com.angularSpring.demoAngSpring.models.Auto;
import com.angularSpring.demoAngSpring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> getAllBy();
    User getUserById(Long userId);
    User getUserByEmail(String email);
    User getUserByRuolo(String ruolo);
    boolean existsByEmail(String email);
    boolean existsByNome(String nome);
}
