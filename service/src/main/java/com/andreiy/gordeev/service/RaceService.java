package com.andreiy.gordeev.service;

import com.andreiy.gordeev.dao.RaceDAO;
import com.andreiy.gordeev.model.Race;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RaceService {

    @Autowired
    private RaceDAO raceDAO;

    public Race getRace() {
        return raceDAO.getRace();
    }
}
