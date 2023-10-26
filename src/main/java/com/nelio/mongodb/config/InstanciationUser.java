package com.nelio.mongodb.config;

import com.nelio.mongodb.domains.User;
import com.nelio.mongodb.repositories.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class InstanciationUser implements CommandLineRunner {

    @Autowired
    private RepositoryUser repo;
    @Override
    public void run(String... args) throws Exception {
        repo.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        repo.saveAll(Arrays.asList(maria, alex, bob));
    }
}
