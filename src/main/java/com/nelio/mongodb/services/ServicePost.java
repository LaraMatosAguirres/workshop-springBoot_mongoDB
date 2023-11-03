package com.nelio.mongodb.services;

import com.nelio.mongodb.domains.Post;
import com.nelio.mongodb.domains.User;
import com.nelio.mongodb.dtos.DTOUser;
import com.nelio.mongodb.repositories.RepositoryPost;
import com.nelio.mongodb.repositories.RepositoryUser;
import com.nelio.mongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicePost {

    @Autowired
    private RepositoryPost repo;

    public Post findById(String id){
        Optional<Post> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Id não encontrado"));
    }

    public List<Post> findByTitle(String text){
        return repo.searchTitle(text);
    }
}
