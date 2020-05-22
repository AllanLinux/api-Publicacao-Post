package com.allan.apiPublicacaoPost.repository;

import com.allan.apiPublicacaoPost.domain.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

// Anotação para indicar que a classe é um repositório
@Repository
public interface UserRepository extends MongoRepository<User, Long> {

    // Originalmente o método FindById ele só aceita Long, como o Id está como String por causa do Mongo tive que criar este método.
    Optional<User> findById(String id);
}
