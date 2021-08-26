package com.project.nosql.resource;

import java.net.URI;
import java.util.List;

import com.project.nosql.dto.userDTO.UserReqDTO;
import com.project.nosql.dto.userDTO.UserReqUpdateDTO;
import com.project.nosql.dto.userDTO.UserRespDTO;
import com.project.nosql.model.User;
import com.project.nosql.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserRespDTO>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRespDTO> findById(@PathVariable String id){
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> fromDTO(@RequestBody UserReqDTO fromDTO) {
        User user = service.creadeUser(fromDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping("/{id}")
     public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
     }

     @PutMapping
     public ResponseEntity<UserRespDTO> updateUser(@RequestBody UserReqUpdateDTO reqDTO){
        return ResponseEntity.ok().body(service.update(reqDTO));
     }

}