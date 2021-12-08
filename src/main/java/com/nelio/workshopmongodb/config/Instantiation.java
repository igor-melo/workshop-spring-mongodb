package com.nelio.workshopmongodb.config;

import com.nelio.workshopmongodb.domain.Post;
import com.nelio.workshopmongodb.domain.User;
import com.nelio.workshopmongodb.dto.AuthorDTO;
import com.nelio.workshopmongodb.dto.CommentDTO;
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

        userRepository.saveAll(Arrays.asList(joao, maria ,helena,alice, laura, manuela, sophia, isabella ));

        Post post1 = new Post(null, sdf.parse("01/03/2018"), "Partiu viagem!", "Vou viajar para SP abraços!", new AuthorDTO(joao));
        Post post2 = new Post(null, sdf.parse("15/03/2018"), "Dicas rápidas", "Beba agua", new AuthorDTO(maria));
        Post post3 = new Post(null, sdf.parse("06/04/2018"), "Sites gratuitos", "Google", new AuthorDTO(helena));
        Post post4 = new Post(null, sdf.parse("18/06/2018"), "Dicas para melhorar ", "Se ajude", new AuthorDTO(alice));
        Post post5 = new Post(null, sdf.parse("11/07/2018"), "O segredo", "Nao conto", new AuthorDTO(joao));

        CommentDTO c1 = new CommentDTO("Boa viagem!", sdf.parse("02/03/2018"), new AuthorDTO(laura));
        CommentDTO c2 = new CommentDTO("Vai pela sombra.", sdf.parse("01/03/2018"), new AuthorDTO(manuela));
        CommentDTO c3 = new CommentDTO("Vamos hidratar!", sdf.parse("15/03/2018"), new AuthorDTO(sophia));
        CommentDTO c4 = new CommentDTO("Ate vó ja sabia esse", sdf.parse("06/04/2018"), new AuthorDTO(isabella));
        CommentDTO c5 = new CommentDTO("Nem eu", sdf.parse("12/07/2018"), new AuthorDTO(maria));

        post1.getComments().addAll(Arrays.asList(c1,c2));
        post2.getComments().addAll(Arrays.asList(c3));
        post3.getComments().addAll(Arrays.asList(c4));
        post5.getComments().addAll(Arrays.asList(c5));

        postRepository.saveAll(Arrays.asList(post1,post2,post3,post4,post5));

        joao.getPosts().addAll(Arrays.asList(post1, post5));
        maria.getPosts().addAll(Arrays.asList(post2));
        helena.getPosts().addAll(Arrays.asList(post3));
        alice.getPosts().addAll(Arrays.asList(post4));

        userRepository.saveAll(Arrays.asList(joao,maria,helena,alice));

    }
}
