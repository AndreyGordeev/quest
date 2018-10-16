package com.andreiy.gordeev.dao;

import com.andreiy.gordeev.model.Race;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RaceDAOImpl implements RaceDAO {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public RaceDAOImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public List<Race> getRaceList() {
        String sql = "SELECT * FROM Race";
        List<Race> raceList = jdbcTemplate.query(sql, new RowMapper<Race>() {

            public Race mapRow(ResultSet rs, int rowNum) throws SQLException {
                Race race = new Race();
                race.setId(rs.getInt("id"));
                race.setName(rs.getString("name"));
                return race;
            }

        });
        return raceList;
    }
}
