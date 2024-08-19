package com.example.myproject.config;

import com.example.myproject.model.AppUser;
import com.example.myproject.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        AppUser user = new AppUser();
        user.setUsername("admin");
        user.setPassword(new BCryptPasswordEncoder().encode("admin123"));
        user.setEmail("taleh.ilqar8@gmail.com");

        userRepository.save(user);
    }
}
