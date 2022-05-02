package com.angularSpring.demoAngSpring.dao;

import com.angularSpring.demoAngSpring.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
}
