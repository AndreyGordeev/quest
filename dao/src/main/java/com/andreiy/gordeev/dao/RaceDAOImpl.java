package com.andreiy.gordeev.dao;

import com.andreiy.gordeev.model.Race;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RaceDAOImpl implements RaceDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public RaceDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Race> getRaceList() {
        String sql = "SELECT * FROM Race";
        List<Race> raceList = jdbcTemplate.query(sql, (rs, rowNum) -> {
            Race race = new Race();
            race.setId(rs.getInt("id"));
            race.setName(rs.getString("name"));
            return race;
        });
        return raceList;
    }
}
