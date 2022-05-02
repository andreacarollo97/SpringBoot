package com.angularSpring.demoAngSpring.services;


import com.angularSpring.demoAngSpring.dao.AutoDao;
import com.angularSpring.demoAngSpring.models.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutoServiceImpl implements AutoService {

    @Autowired
    private AutoDao autoDao;


    @Override
    public Auto save(Auto auto) {
        return autoDao.save(auto);
    }

    @Override
    public Auto findById(Long id) {
        return autoDao.findById(id).orElse(null);
    }

    @Override
    public List<Auto> findAll() {
        return autoDao.findAll();
    }

    @Override
    public void delete(Long id) {
        autoDao.deleteById(id);
    }
}
