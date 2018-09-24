package com.andreiy.gordeev.dao;

import com.andreiy.gordeev.model.Race;
import org.springframework.stereotype.Repository;

@Repository
public class RaceDAOImpl implements RaceDAO {

    public Race getRace() {
        Race race = new Race();
        race.setRaceName("Human");
        return race;
    }
}
