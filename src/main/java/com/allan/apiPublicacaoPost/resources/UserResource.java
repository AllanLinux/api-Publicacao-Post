package com.allan.apiPublicacaoPost.resources;

import com.allan.apiPublicacaoPost.domain.User;
import com.allan.apiPublicacaoPost.dto.UserDTO;
import com.allan.apiPublicacaoPost.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
    @GetMapping(value = "/{id}")
    // PathVariable usado quando o valor da variavel é passado diretamente na URL
    public ResponseEntity<UserDTO> findById(@PathVariable String id) {
        User obj = service.findById(id);

        return ResponseEntity.ok().body(new UserDTO(obj));
    }
    //
    @PostMapping()
    // PathVariable usado quando o valor da variavel é passado diretamente na URL
    public ResponseEntity<Void> insert(@RequestBody UserDTO objDto) {
        User obj = service.fromDTO(objDto);
        obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
        // metodo created retorna o código 201 com cabeçalho contendo o id do recurso criado
        return ResponseEntity.created(uri).build();
        
    }


}
