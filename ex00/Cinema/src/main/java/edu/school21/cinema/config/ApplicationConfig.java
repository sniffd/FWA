package edu.school21.cinema.config;

import com.zaxxer.hikari.HikariDataSource;
import edu.school21.cinema.repositories.UserRepository;
import edu.school21.cinema.repositories.UserRepositoryImpl;
import edu.school21.cinema.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.SQLException;

@Configuration
@ComponentScan("edu.school21.cinema")
@PropertySource("classpath:../application.properties")
public class ApplicationConfig {

    @Value("${db.url}")
    private String url;

    @Value("${db.user}")
    private String user;

    @Value("${db.password}")
    private String password;

    @Value("${db.driver.name}")
    private String driverName;

    @Bean
    public HikariDataSource dataSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setJdbcUrl(url);
        ds.setUsername(user);
        ds.setPassword(password);
        ds.setDriverClassName(driverName);
        return ds;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserRepositoryImpl userRepository(@Autowired DataSource ds) throws SQLException, IOException {
        return new UserRepositoryImpl(ds);
    }

    @Bean
    public UserService userService(@Autowired UserRepository ur, PasswordEncoder pe) throws SQLException, IOException {
        return new UserService(ur, pe);
    }
}

