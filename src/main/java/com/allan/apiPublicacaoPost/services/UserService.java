package com.allan.apiPublicacaoPost.services;

import com.allan.apiPublicacaoPost.domain.User;
import com.allan.apiPublicacaoPost.dto.UserDTO;
import com.allan.apiPublicacaoPost.repository.UserRepository;
import com.allan.apiPublicacaoPost.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// Anotação para indicar que a classe será do tipo "Service"
@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    // Retornando todos os usuários
    public List<User> findAll() {
        return repo.findAll();
    }
    // Retornando usuário pelo id
    public User findById(String id) {
        Optional<User> obj = repo.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
    }
    // Inserindo usuário
    public User insert(User obj) {
        return repo.insert(obj);
    }

    public User fromDTO(UserDTO objDto) {
        return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
    }
}