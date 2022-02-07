package edu.school21.cinema.services;

import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean saveUser(String firstname, String lastname, String email, String phone, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            return false;
        }
        userRepository.save(new User(firstname, lastname, email, phone, passwordEncoder.encode(password)));
        return true;
    }

    public boolean authorizeUser(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (!optionalUser.isPresent()) {
            return false;
        }
        User user = optionalUser.get();
        return user.getPassword().equals(passwordEncoder.encode(password));
    }
}
