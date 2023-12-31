package com.nelio.mongodb.services;

import com.nelio.mongodb.domains.User;
import com.nelio.mongodb.dtos.DTOUser;
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

    public User insert(User obj){
        return repo.insert(obj);
    }

    public User fromDTO(DTOUser obj){
        return new User(obj.getId(), obj.getName(), obj.getEmail());
    }

    public void delet(String id){
        findById(id);
        repo.deleteById(id);
    }

    public User update(User obj){
         User newObj = findById(obj.getId());
        updateData(newObj, obj);
        return repo.save(newObj);
    }

    private void updateData(User newObj, User obj) {
        newObj.setName(obj.getName());
        newObj.setEmail(obj.getEmail());
    }
}
