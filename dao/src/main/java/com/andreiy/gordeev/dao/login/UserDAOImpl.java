package com.andreiy.gordeev.dao.login;

import com.andreiy.gordeev.model.Role;
import com.andreiy.gordeev.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class UserDAOImpl implements UserDAO {

    private static final String SELECT_BY_USERNAME_SQL = "SELECT u.id, u.username, u.password, u.passwordConfirm, r.id, r.name " +
            "FROM User u INNER JOIN UserRole ur ON u.id = ur.userId " +
            "INNER JOIN Role r on ur.roleId = r.id WHERE username = ?";

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User findByUsername(String username) {
        List<RawUser> rawUserList = jdbcTemplate.query(SELECT_BY_USERNAME_SQL, new UserRowMapper());

        if (rawUserList.size() < 1) {
            return null;
        }

        User user = new User();
        user.setId(rawUserList.get(0).getId());
        user.setUsername(rawUserList.get(0).getUsername());
        user.setPassword(rawUserList.get(0).getPassword());
        user.setPasswordConfirm(rawUserList.get(0).getPasswordConfirm());

        List<Role> userRoles = rawUserList.stream().map(rawUser -> {
            Role role = new Role();
            role.setId(rawUser.getRoleId());
            role.setName(rawUser.getRoleName());
            return role;
        }).collect(Collectors.toList());

        user.setRole(userRoles);

        return user;
    }

    private class UserRowMapper implements RowMapper<RawUser> {

        @Override
        public RawUser mapRow(ResultSet rs, int rowNum) throws SQLException {
            RawUser rawUser = new RawUser();

            rawUser.setId(rs.getInt("u.id"));
            rawUser.setUsername(rs.getString("u.username"));
            rawUser.setPassword(rs.getString("u.password"));
            rawUser.setPasswordConfirm(rs.getString("u.passwordConfirm"));
            rawUser.setRoleId(rs.getInt("r.id"));
            rawUser.setRoleName(rs.getString("r.name"));

            return rawUser;
        }
    }

    private class RawUser {
        private int id;
        private String username;
        private String password;
        private String passwordConfirm;
        private int roleId;
        private String roleName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getPasswordConfirm() {
            return passwordConfirm;
        }

        public void setPasswordConfirm(String passwordConfirm) {
            this.passwordConfirm = passwordConfirm;
        }

        public int getRoleId() {
            return roleId;
        }

        public void setRoleId(int roleId) {
            this.roleId = roleId;
        }

        public String getRoleName() {
            return roleName;
        }

        public void setRoleName(String roleName) {
            this.roleName = roleName;
        }
    }
}
