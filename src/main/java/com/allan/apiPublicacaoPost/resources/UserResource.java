package com.allan.apiPublicacaoPost.resources;

import com.allan.apiPublicacaoPost.domain.User;
import com.allan.apiPublicacaoPost.dto.UserDTO;
import com.allan.apiPublicacaoPost.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Determina que a classe terá um controlador Rest
@RestController
// Determinando o path da rest
@RequestMapping(value = "/users")
public class UserResource {

    // Injeção de UserService
    @Autowired
    private UserService service;

    // Definindo que será uma operação do tipo GET
    @GetMapping
    /*
        O retorno do tipo ResponseEntity permite que o retorno encapsular toda uma estrutura necessária para retornar
        respostas Http, ja com possiveis cabeçalhos, possíveis erros, etc.
     */
    public ResponseEntity<List<UserDTO>> findAll() {
        List<User> list = service.findAll();
        List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDto);
    }

}
