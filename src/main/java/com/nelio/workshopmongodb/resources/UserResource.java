package com.nelio.workshopmongodb.resources;

import com.nelio.workshopmongodb.domain.User;
import com.nelio.workshopmongodb.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserResource {


    @Autowired
    private UserService service;

    @GetMapping
    //ResponseEntity encapsula para retorno http
    public ResponseEntity<List<User>> findAll(){
//        User maria = new User("1", "maria", "maria@gmail.com");
//        User alex = new User("2", "alex", "alex@gmail.com");

        List<User> list = service.findAll();
//        list.addAll(Arrays.asList(maria, alex));
        return ResponseEntity.ok().body(list);
    }
}
