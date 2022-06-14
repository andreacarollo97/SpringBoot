package com.angularSpring.demoAngSpring.repository;


import com.angularSpring.demoAngSpring.models.Auto;
import com.angularSpring.demoAngSpring.models.ParcoAuto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutoRepository extends JpaRepository<Auto, Long> {

    List<Auto> getAutoByIdNotIn(List<Long> autoId);
    List<Auto> getAllBy();
    Auto getAutoById(Long autoId);
    List<Auto> getAllByParcoAutoId(Long id);

    List<Auto> getAutoByParcoAutoIsNull();
    Auto getAutoByParcoAutoId(Long id);



}
