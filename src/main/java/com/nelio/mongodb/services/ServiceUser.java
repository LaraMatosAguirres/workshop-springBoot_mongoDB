package com.nelio.mongodb.services;

import com.nelio.mongodb.domains.User;
import com.nelio.mongodb.repositories.RepositoryUser;
import com.nelio.mongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceUser {

    @Autowired
    private RepositoryUser repo;

    public List<User> findAll(){
       return repo.findAll();
    }

    public User findById(String id){
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Id não encontrado"));
    }
}
