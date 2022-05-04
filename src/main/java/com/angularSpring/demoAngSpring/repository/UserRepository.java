package com.angularSpring.demoAngSpring.repository;

import com.angularSpring.demoAngSpring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
