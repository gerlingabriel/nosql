package com.project.nosql.resource;

import java.util.List;

import com.project.nosql.dto.postDTO.PostRespDTO;
import com.project.nosql.model.Post;
import com.project.nosql.model.User;
import com.project.nosql.service.PostService;
import com.project.nosql.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostResource {

    @Autowired
    private UserService userService;
    @Autowired
    private PostService postService;

    @GetMapping("/{id}")
    public ResponseEntity<List<Post>> findPostsOfUser(@PathVariable String id){
        User user = userService.searchForUser(id);
        return ResponseEntity.ok().body(user.getPosts());
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<PostRespDTO> findByID(@PathVariable String id){
        return ResponseEntity.ok().body(postService.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<PostRespDTO>> findall(){
        return ResponseEntity.ok().body(postService.findAll());
    }

    @GetMapping("/buscar/{name}")
    public ResponseEntity<List<PostRespDTO>> findByTitle(@PathVariable String name){
        return ResponseEntity.ok().body(postService.findByTitle(name));
    }
    
}
