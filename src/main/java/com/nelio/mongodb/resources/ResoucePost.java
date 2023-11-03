package com.nelio.mongodb.resources;


import com.nelio.mongodb.domains.Post;
import com.nelio.mongodb.domains.User;
import com.nelio.mongodb.dtos.DTOUser;
import com.nelio.mongodb.resources.util.URL;
import com.nelio.mongodb.services.ServicePost;
import com.nelio.mongodb.services.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class ResoucePost {

    @Autowired
    private ServicePost service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<List<Post>> findById(@PathVariable String id){
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(Collections.singletonList(obj));
    }

    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
        text = URL.decodeParam(text);
        List<Post> list = service.findByTitle(text);
        return ResponseEntity.ok().body(list);
    }

}
