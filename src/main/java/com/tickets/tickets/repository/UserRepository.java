package com.tickets.tickets.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.tickets.tickets.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> getByEmail(String email);

    Page<User> getAllByName(Pageable pageable, String name);

    Boolean existsByEmail(String email);
}
