package com.project.nosql.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import com.project.nosql.dto.Comments.CommetsDTO;
import com.project.nosql.dto.userDTO.UserDTO;
import com.project.nosql.model.Post;
import com.project.nosql.model.User;
import com.project.nosql.repository.PostRepository;
import com.project.nosql.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner{

    @Autowired
    private UserRepository repository;
    @Autowired
    private PostRepository postRepository;

    // Instaciar algumas class para testar
    @Override
    public void run(String... args) throws Exception {

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        format.setTimeZone(TimeZone.getTimeZone("GMT"));

        repository.deleteAll();
        postRepository.deleteAll();

        User gabriel = new User(null, "Gabriel Gerlin Dias", "gerlin.gabriel@gamil.com");
        User rafael = new User(null, "Rafafel Gerlin Dias", "gerlinadldinho@hotmail.com");
        User barbara = new User(null, "Bárbara Cristino Glinardello Melo", "binhaglinarddello@gmail.com");

        repository.saveAll(Arrays.asList(gabriel, rafael, barbara));

        Post post1 = new Post(null, format.parse("21/01/2019"), "Foto enviada para mozão! Livros", "Como é bom livros", new UserDTO(gabriel.getId(), gabriel.getName()));
        Post post2 = new Post(null, format.parse("21/05/2020"), "Tentando malhar!", "Será que consigo",  new UserDTO(gabriel.getId(), gabriel.getName()));

        CommetsDTO comment = new CommetsDTO("Livros, adoro", format.parse("15/02/2019"), new UserDTO(barbara.getId(), barbara.getName()));
        CommetsDTO comment2 = new CommetsDTO("Que livro negocio é soccer", format.parse("15/02/2019"), new UserDTO(rafael.getId(), rafael.getName()));
        CommetsDTO comment3 = new CommetsDTO("Também quero ;/", format.parse("15/02/2019"), new UserDTO(barbara.getId(), barbara.getName()));

        post1.getComments().addAll(Arrays.asList(comment, comment2));
        post2.getComments().add(comment3);

        postRepository.saveAll(Arrays.asList(post1, post2));

        gabriel.getPosts().add(post1);
        gabriel.getPosts().add(post2);

        repository.save(gabriel);

    }

}