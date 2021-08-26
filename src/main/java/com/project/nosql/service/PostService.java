package com.project.nosql.service;

import java.util.List;
import java.util.stream.Collectors;

import com.project.nosql.dto.postDTO.PostRespDTO;
import com.project.nosql.exception.ObjectNotFoundException;
import com.project.nosql.model.Post;
import com.project.nosql.repository.PostRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public List<PostRespDTO> findAll(){
        return repository.findAll()
                .stream()
                .map(dado -> new PostRespDTO(dado.getDate(), dado.getTitle(), dado.getBoby(), dado.getUser(), dado.getComments()))
                .collect(Collectors.toList());
    }

    public PostRespDTO findById(String id) {
        Post post =  searchForPost(id);
        return new PostRespDTO(post.getDate(), post.getTitle(), post.getBoby(), post.getUser(), post.getComments());
    }

    // public User creadeUser(UserReqDTO fromDTO) {
     //   User user = new User(null, fromDTO.getNome(), fromDTO.getEmail());
   //     return repository.insert(user);
    //}

    /**
    public void delete(String id) {
        searchForUser(id);
        repository.deleteById(id);
    }

    public UserRespDTO update(UserReqUpdateDTO user){
        User novoUser = searchForUser(user.getId());
        return updateDataConvertDTO(user, novoUser);
    }
    */

    public Post searchForPost(String id){
        Post post = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Post não existe"));
        return post;
    }


    public List<PostRespDTO> findByTitle(String name) {
        return repository.searchTitle(name)
                    .stream()
                    .map(dado -> new PostRespDTO(dado.getDate(), dado.getTitle(), dado.getBoby(), dado.getUser(), dado.getComments()))
                    .collect(Collectors.toList());
    }

    /**
    // Métodos privados

    private UserRespDTO updateDataConvertDTO(UserReqUpdateDTO user, User novoUser) {
        novoUser.setName(user.getNome());
        novoUser.setEmail(user.getEmail());
        repository.save(novoUser);
        return new UserRespDTO(novoUser.getName(), novoUser.getEmail());
    }
    */



}
