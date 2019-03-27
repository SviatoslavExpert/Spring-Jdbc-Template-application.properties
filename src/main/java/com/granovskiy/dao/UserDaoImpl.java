package com.granovskiy.dao;

import com.granovskiy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDaoImpl implements UserDao {

    //  JDBC template is used (much cooler than JDBC)
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User getByUsername(String username) {
        return jdbcTemplate.queryForObject("SELECT * FROM USERS U WHERE U.USERNAME = ?", new Object[] {username}, new UserMapper());
    }

    class UserMapper implements RowMapper<User> {

        public User mapRow(ResultSet resultSet, int i) throws SQLException {
            User user = new User();
            user.setId(resultSet.getLong("ID"));
            user.setUsername(resultSet.getString("USERNAME"));
            user.setPassword(resultSet.getString("PASSWORD"));
            user.setToken(resultSet.getString("TOKEN"));
            user.setFirstName(resultSet.getString("FIRST_NAME"));
            user.setLastName(resultSet.getString("LAST_NAME"));
            return user;
        }
    }
}
