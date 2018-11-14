package com.andreiy.gordeev.dao.race;

import com.andreiy.gordeev.dao.race.RaceDAO;
import com.andreiy.gordeev.model.Race;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RaceDAOImpl implements RaceDAO {

    private static final String SELECT_RACES_SQL = "SELECT * FROM Race";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public RaceDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Race> getRaceList() {
        List<Race> raceList = jdbcTemplate.query(SELECT_RACES_SQL, new RaceRowMapper());
        return raceList;
    }

    private class RaceRowMapper implements RowMapper<Race> {

        @Override
        public Race mapRow(ResultSet rs, int rowNum) throws SQLException {
            Race race = new Race();
            race.setId(rs.getInt("id"));
            race.setName(rs.getString("name"));
            return race;
        }
    }
}
