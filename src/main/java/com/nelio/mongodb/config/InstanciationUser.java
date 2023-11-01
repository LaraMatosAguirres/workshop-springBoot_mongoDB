package com.nelio.mongodb.config;

import com.nelio.mongodb.domains.Post;
import com.nelio.mongodb.domains.User;
import com.nelio.mongodb.repositories.RepositoryPost;
import com.nelio.mongodb.repositories.RepositoryUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

@Configuration
public class InstanciationUser implements CommandLineRunner {

    @Autowired
    private RepositoryUser repo;

    @Autowired
    private RepositoryPost repositoryPost;

    @Override
    public void run(String... args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        repo.deleteAll();
        repositoryPost.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        Post post1 = new Post(null, sdf.parse("21/08/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", maria);
        Post post2 = new Post(null, sdf.parse("23/03/2018"),  "Bom dia", "Acordei feliz hoje!", maria);

        repo.saveAll(Arrays.asList(maria, alex, bob));
        repositoryPost.saveAll(Arrays.asList(post1, post2));
    }
}
