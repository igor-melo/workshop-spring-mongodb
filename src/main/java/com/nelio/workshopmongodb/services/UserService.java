package com.nelio.workshopmongodb.services;

import com.nelio.workshopmongodb.domain.User;
import com.nelio.workshopmongodb.dto.UserDTO;
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
            throw new ObjectNotFoundException("Objeto não encontrado");
        }

        User userEntity = user.get();

        return userEntity;
    }

    public User insert(User obj){
        return repo.insert(obj);
    }

    public User fromDTO(UserDTO objDto){
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
    public void delete(String id){
        findById(id);
        repo.deleteById(id);
    }

}
