package com.nelio.mongodb.repositories;

import com.nelio.mongodb.domains.Post;
import com.nelio.mongodb.domains.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepositoryPost extends MongoRepository<Post, String> {

    @Query("{ 'title' : { $regex: ?0 , $options: 'i' } }")
    List<Post> searchTitle(String text);

    List<Post> findByTitleContainingIgnoreCase(String text);
}
