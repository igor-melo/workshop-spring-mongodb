package com.nelio.workshopmongodb.services;

import com.nelio.workshopmongodb.domain.Post;
import com.nelio.workshopmongodb.domain.User;
import com.nelio.workshopmongodb.dto.UserDTO;
import com.nelio.workshopmongodb.repository.PostRepository;
import com.nelio.workshopmongodb.repository.UserRepository;
import com.nelio.workshopmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public Post findById(String id){
        Optional<Post> post = repo.findById(id);
        if (post.isEmpty()){
            throw new ObjectNotFoundException("Objeto não encontrado");
        }

        Post userEntity = post.get();

        return userEntity;
    }

    public List<Post> findByTitle(String text){
        return repo.findByTitleContaining(text);
    }


}
