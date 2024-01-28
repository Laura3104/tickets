package com.tickets.tickets.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.tickets.tickets.model.UserAccount;

import java.util.Optional;

@Repository
public interface UserAccountRepository extends MongoRepository<UserAccount, String> {

    Optional<UserAccount> findByUserId(String userId);
}
