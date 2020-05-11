package com.allan.apiPublicacaoPost.config;

import com.allan.apiPublicacaoPost.domain.User;
import com.allan.apiPublicacaoPost.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

// Anotação para o Spring interpretar como configuração
@Configuration
public class Instantiation implements CommandLineRunner {

    // Vai resolver a dependencia e associar uma instancia de UserRepository - Injeção de dependencia
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        userRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        userRepository.saveAll(Arrays.asList(maria, alex, bob));
    }
}
