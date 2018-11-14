package com.andreiy.gordeev.service.race;

import com.andreiy.gordeev.dao.race.RaceDAO;
import com.andreiy.gordeev.model.Race;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RaceService {

    @Autowired
    private RaceDAO raceDAO;

    public String getRaceList() {
        StringBuilder stringBuilder = new StringBuilder("Races: ");
        for (Race race : raceDAO.getRaceList()) {
            stringBuilder.append(race.getName() + ", ");
        }
        return stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length()).append(".").toString();
    }
}
