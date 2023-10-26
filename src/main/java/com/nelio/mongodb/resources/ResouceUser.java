package com.nelio.mongodb.resources;


import com.nelio.mongodb.domains.User;
import com.nelio.mongodb.services.ServiceUser;
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
public class ResouceUser {

    @Autowired
    private ServiceUser service;

    @GetMapping
    public ResponseEntity<List<User>> saveAll (){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
}
