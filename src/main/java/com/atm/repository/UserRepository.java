package com.atm.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.atm.model.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveCrudRepository<User, Integer> {

    Flux<User> findAll();
    Mono<User> findById(int id);
    Mono<User> save(User user);
}

