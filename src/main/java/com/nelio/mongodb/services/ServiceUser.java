package com.nelio.mongodb.services;

import com.nelio.mongodb.domains.User;
import com.nelio.mongodb.repositories.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceUser {

    @Autowired
    private RepositoryUser repo;

    public List<User> findAll(){
       return repo.findAll();
    }
}
