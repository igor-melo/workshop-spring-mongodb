package com.nelio.workshopmongodb.services;

import com.nelio.workshopmongodb.domain.User;
import com.nelio.workshopmongodb.repository.UserRepository;
import com.nelio.workshopmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id){
        Optional<User> user = repo.findById(id);
        if (user.isEmpty()){
            throw new ObjectNotFoundException("Objeto nao encontrado");
        }

        User userEntity = user.get();
//        u.setId(user.get().getId());
//        u.setName(user.get().getName());
//        u.setEmail(user.get().getEmail());

        return userEntity;
    }
}
