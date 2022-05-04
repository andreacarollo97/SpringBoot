package com.angularSpring.demoAngSpring.repository;


import com.angularSpring.demoAngSpring.models.Auto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutoRepository extends JpaRepository<Auto, Long> {

    List<Auto> getAutoByIdNotIn(List<Long> autoId);
}
