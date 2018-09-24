package com.andreiy.gordeev.dao;

import com.andreiy.gordeev.model.Race;
import org.springframework.stereotype.Repository;

import java.util.Random;

@Repository
public class RaceDAOImpl implements RaceDAO {

    public Race getRace() {
        Race race = new Race();
        race.setRaceName("Human " + getRandomNumber());
        return race;
    }

    public int getRandomNumber() {
        Random rand = new Random();
        return rand.nextInt(100);
    }
}
