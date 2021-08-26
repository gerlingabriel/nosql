package com.project.nosql.service;

import java.util.Calendar;
import java.util.Date;
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

    public List<Post> fullsearch(String text, Date minDate, Date maxDate){

        if (minDate == null) {
            Calendar c = Calendar.getInstance();
		    c.set(2019, Calendar.JANUARY, 01);
            minDate = c.getTime();
        }
        
        if (maxDate == null) {
            Calendar c = Calendar.getInstance();
		    c.set(2019, Calendar.JANUARY, 30);
            maxDate = c.getTime();
        }

        maxDate = new Date(maxDate.getTime() + 24 *60 * 60 * 1000);
        return repository.fullserach(text, minDate, maxDate);
    }


}
