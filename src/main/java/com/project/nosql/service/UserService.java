package com.project.nosql.service;

import java.util.List;
import java.util.stream.Collectors;

import com.project.nosql.dto.userDTO.UserReqDTO;
import com.project.nosql.dto.userDTO.UserReqUpdateDTO;
import com.project.nosql.dto.userDTO.UserRespDTO;
import com.project.nosql.exception.ObjectNotFoundException;
import com.project.nosql.model.User;
import com.project.nosql.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserRespDTO> findAll(){
        return repository.findAll()
                .stream()
                .map(user -> new UserRespDTO(user.getName(), user.getEmail()))
                .collect(Collectors.toList());
    }

    public UserRespDTO findById(String id) {
        User user =  searchForUser(id);
        return new UserRespDTO(user.getName(), user.getEmail());
    }

    public User creadeUser(UserReqDTO fromDTO) {
        User user = new User(null, fromDTO.getNome(), fromDTO.getEmail());
        return repository.insert(user);
    }

    public void delete(String id) {
        searchForUser(id);
        repository.deleteById(id);
    }

    public UserRespDTO update(UserReqUpdateDTO user){
        User novoUser = searchForUser(user.getId());
        return updateDataConvertDTO(user, novoUser);
    }

    
    public User searchForUser(String id){
        User user = repository.findById(id).orElseThrow(() -> new ObjectNotFoundException("Usuário não existe"));
        return user;
    }

    // Métodos privados
    private UserRespDTO updateDataConvertDTO(UserReqUpdateDTO user, User novoUser) {
        novoUser.setName(user.getNome());
        novoUser.setEmail(user.getEmail());
        repository.save(novoUser);
        return new UserRespDTO(novoUser.getName(), novoUser.getEmail());
    }

}
