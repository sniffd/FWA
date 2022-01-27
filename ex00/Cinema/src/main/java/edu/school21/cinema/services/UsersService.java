package edu.school21.cinema.services;

import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("userService")
public class UsersService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    @Qualifier("encodePassword")
    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Autowired
    @Qualifier("usersRepository")
    public void setUsersRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean saveUser(String firstname, String lastname, String email, String phone, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            return false;
        } else {
            userRepository.save(new User(null, firstname, lastname, email, phone, passwordEncoder.encode(password)));
            return true;
        }
    }

    public boolean autorizeUser(String email, String password) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            return false;
        } else {
            User user = optionalUser.get();
            return user.getPassword().equals(passwordEncoder.encode(password));
        }
    }
}
