package com.nelio.mongodb.repositories;

import com.nelio.mongodb.domains.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryUser extends MongoRepository<User , String> {

}
