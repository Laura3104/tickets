package com.tickets.tickets.postgres.repository;

import com.tickets.tickets.postgres.model.UserAccountPostgres;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAccountPostgresRepository extends CrudRepository<UserAccountPostgres, Long> {

    Optional<UserAccountPostgres> findByUserId(Long userId);
}
