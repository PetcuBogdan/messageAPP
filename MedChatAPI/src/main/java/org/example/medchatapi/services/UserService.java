package org.example.medchatapi.services;

import org.example.medchatapi.dto.User;
import org.example.medchatapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String saveUser(User user) {
        userRepository.save(user);
        return "OK";
    }

    public String validateUser(User user) {
        // Verifică și manipulează datele, apoi salvează în baza de date
        if(!isValidEmail(user.getEmail()))  {
            return "Invalid email!";
        }
        if(!isValidPassword(user.getPassword())) {
            return "Invalid password!";
        }
        return "OK";
    }

    public String validateLogin(User user) {
        Optional<User> userOptional = userRepository.findByEmail(user.getEmail());

        if(userOptional.isPresent()) {
            User userFound = userOptional.get();
            if(user.getPassword().equals(userFound.getPassword())){
                return "OK";
            } else {
                return "Wrong password";
            }
        }
        return "Wrong email";
    }

    public static Boolean isValidPassword(String password) {
        // Password should have at least 8 characters, one uppercase letter, one digit, and one special character
        String passwordRegex = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

        // Creating a Pattern object
        Pattern pattern = Pattern.compile(passwordRegex);

        // Creating a matcher object
        Matcher matcher = pattern.matcher(password);

        // Returning true if the password matches the pattern, false otherwise
        return matcher.matches();

    }

    public static boolean isValidEmail(String email) {
        // Regular expression for a basic email validation
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        // Creating a Pattern object
        Pattern pattern = Pattern.compile(emailRegex);

        // Creating a matcher object
        Matcher matcher = pattern.matcher(email);

        // Returning true if the email matches the pattern, false otherwise
        return matcher.matches();
    }
}
