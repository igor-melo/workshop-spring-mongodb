package com.nelio.workshopmongodb.config;

import com.nelio.workshopmongodb.domain.Post;
import com.nelio.workshopmongodb.domain.User;
import com.nelio.workshopmongodb.repository.PostRepository;
import com.nelio.workshopmongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class Instantiation implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        userRepository.deleteAll();
        postRepository.deleteAll();

        User joao = new User(null, "João", "joao@mail.com");
        User maria = new User(null, "Maria", "maria@mail.com");
        User helena = new User(null, "helena", "Helena@mail.com");
        User alice = new User(null, "alice", "Alice@mail.com");
        User laura = new User(null, "laura", "Laura@mail.com");
        User manuela = new User(null, "manuela", "Manuela@mail.com");
        User sophia = new User(null, "sophia", "Sophia@mail.com");
        User isabella = new User(null, "isabella", "Isabella@mail.com");

        Post post1 = new Post(null, sdf.parse("01/03/2018"), "Partiu viagem!", "Vou viajar para SP abraços!", joao);
        Post post2 = new Post(null, sdf.parse("15/03/2018"), "Dicas rápidas", "Beba agua", maria);
        Post post3 = new Post(null, sdf.parse("06/04/2018"), "Sites gratuitos", "Google", helena);
        Post post4 = new Post(null, sdf.parse("18/06/2018"), "Dicas para melhorar ", "Se ajude", alice);
        Post post5 = new Post(null, sdf.parse("11/07/2018"), "O segredo", "Nao conto", joao);

        userRepository.saveAll(Arrays.asList(joao, maria ,helena,alice, laura, manuela, sophia, isabella ));
        postRepository.saveAll(Arrays.asList(post1,post2,post3,post4,post5));

    }
}
