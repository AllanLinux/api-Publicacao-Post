package com.allan.apiPublicacaoPost.resources;

import com.allan.apiPublicacaoPost.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Determina que a classe terá um controlador Rest
@RestController
// Determinando o path da rest
@RequestMapping(value = "/users")
public class UserResource {

    // Definindo que será uma operação do tipo GET
    @GetMapping
    /*
        O retorno do tipo ResponseEntity permite que o retorno encapsular toda uma estrutura necessária para retornar
        respostas Http, ja com possiveis cabeçalhos, possíveis erros, etc.
     */
    public ResponseEntity<List<User>> findAll() {
        User maria = new User("1", "Maria Brown", "maria@gmail.com");
        User alex = new User("2", "Alex Green", "alex@gmail.com");
        List<User> list = new ArrayList<>();
        list.addAll(Arrays.asList(maria, alex));
        return ResponseEntity.ok().body(list);
    }

}
