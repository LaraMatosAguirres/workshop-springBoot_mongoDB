package com.nelio.mongodb.resources;


import com.nelio.mongodb.domains.User;
import com.nelio.mongodb.dtos.DTOUser;
import com.nelio.mongodb.services.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/users")
public class ResouceUser {

    @Autowired
    private ServiceUser service;

    @GetMapping
    public ResponseEntity<List<DTOUser>> saveAll (){
        List<User> list = service.findAll();
        List<DTOUser> dtoUsers = list.stream().map(x -> new DTOUser(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(dtoUsers);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<DTOUser>> findById(@PathVariable String id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(Collections.singletonList(new DTOUser(obj)));
    }
}
