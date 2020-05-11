package com.allan.apiPublicacaoPost.repository;

import com.allan.apiPublicacaoPost.domain.User;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

// Anotação para indicar que a classe é um repositório
@Repository
public interface UserRepository extends MongoRepository<User, Long> {
}
