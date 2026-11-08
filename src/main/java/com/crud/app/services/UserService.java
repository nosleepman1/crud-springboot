package com.crud.app.services;

import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.crud.app.entities.User;
import com.crud.app.repositories.UserRepository;

@Service 
public class UserService {
    
    private final UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public UserService(
            UserRepository userRepository,
            PasswordEncoder passwordEncoder
    ){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User register(User user) {

        User existingUser = userRepository.findByEmail(user.getEmail());

        if (existingUser != null) throw new RuntimeException("User already exists");

        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return this.userRepository.save(user);
    }

    public String login(String email, String password) throws Exception {
        User user = this.userRepository.findByEmail(email);

        if(user == null) throw new Exception("utilisateur non trouvé");

        boolean passwordsMatch = passwordEncoder.matches(password, user.getPassword());

        if(!passwordsMatch) throw new Exception("passwords don't match");

        return "Long_Token_JWT_YEAHHHHH";


    } 
}
