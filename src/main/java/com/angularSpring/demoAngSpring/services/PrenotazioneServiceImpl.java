package com.angularSpring.demoAngSpring.services;


import com.angularSpring.demoAngSpring.dao.PrenotazioneDao;
import com.angularSpring.demoAngSpring.models.Auto;
import com.angularSpring.demoAngSpring.models.Prenotazione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrenotazioneServiceImpl implements PrenotazioneService {

    @Autowired
    private PrenotazioneDao prenotazioneDao;


    @Override
    public Prenotazione save(Prenotazione prenotazione) {
        return prenotazioneDao.save(prenotazione);
    }

    @Override
    public Prenotazione findById(Long id) {
        return prenotazioneDao.findById(id).orElse(null);
    }

    @Override
    public List<Prenotazione> findAll() {
        return prenotazioneDao.findAll();
    }

    @Override
    public void delete(Long id) {
        prenotazioneDao.deleteById(id);
    }

}
