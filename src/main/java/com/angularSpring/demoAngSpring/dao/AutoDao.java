package com.angularSpring.demoAngSpring.dao;


import com.angularSpring.demoAngSpring.models.Auto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoDao extends JpaRepository<Auto, Long> {
}
