package com.nelio.workshopmongodb.config;

import com.nelio.workshopmongodb.domain.User;
import com.nelio.workshopmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();

        User joao = new User(null, "João", "joao@mail.com");
        User maria = new User(null, "Maria", "maria@mail.com");
        User helena = new User(null, "helena", "Helena@mail.com");
        User alice = new User(null, "alice", "Alice@mail.com");
        User laura = new User(null, "laura", "Laura@mail.com");
        User manuela = new User(null, "manuela", "Manuela@mail.com");
        User sophia = new User(null, "sophia", "Sophia@mail.com");
        User isabella = new User(null, "isabella", "Isabella@mail.com");

        userRepository.saveAll(Arrays.asList(joao, maria ,helena,alice, laura, manuela, sophia, isabella ));

    }
}
