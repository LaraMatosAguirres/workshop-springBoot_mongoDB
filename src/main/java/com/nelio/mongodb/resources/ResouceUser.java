package com.nelio.mongodb.resources;


import com.nelio.mongodb.domains.User;
import com.nelio.mongodb.dtos.DTOUser;
import com.nelio.mongodb.services.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @PostMapping
    public ResponseEntity<List<DTOUser>> insert(@RequestBody DTOUser user){
        User obj = service.fromDTO(user);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id){
        service.delet(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Void>  update(@RequestBody DTOUser user, @PathVariable String id) {
        User obj = service.fromDTO(user);
        obj.setId(id);
        service.update(obj);
        return ResponseEntity.noContent().build();
    }
}
