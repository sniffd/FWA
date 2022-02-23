package edu.school21.cinema.repositories;

import edu.school21.cinema.models.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    public UserRepositoryImpl(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
    }

    private final RowMapper<User> userRowMapper = (resultSet, rowNum) -> {
        return new User(resultSet.getLong("id"), resultSet.getString("firstname"),
                resultSet.getString("lastname"), resultSet.getString("email"),
                resultSet.getString("phone"), resultSet.getString("password"));
    };

    @Override
    public Optional<User> findById(Long id) {
        try {
            User user = jdbcTemplate.queryForObject("SELECT * FROM users WHERE id = ?", userRowMapper, id);
            return Optional.ofNullable(user);
        } catch (DataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query("SELECT * FROM users", userRowMapper);
    }

    @Override
    public void save(User user) {
        jdbcTemplate.update("INSERT INTO users (firstname, lastname, email, phone, password) VALUES (?, ?, ?, ?, ?)",
                user.getFirstname(), user.getLastname(), user.getEmail(), user.getPhone(), user.getPassword());
    }

    @Override
    public void update(User user) {
        jdbcTemplate.update("UPDATE users SET firstname = ?, lastname = ?, email = ?, phone = ?, password = ? WHERE id = ?",
                user.getFirstname(), user.getLastname(), user.getEmail(), user.getPhone(), user.getPassword(), user.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM users WHERE id = ?", id);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        try {
            User user = jdbcTemplate.queryForObject("SELECT * FROM users WHERE email = ?", userRowMapper, email);
            return Optional.ofNullable(user);
        } catch (DataAccessException e) {
            return Optional.empty();
        }
    }

}
