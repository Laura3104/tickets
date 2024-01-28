package com.tickets.tickets.postgres.repository;

import com.tickets.tickets.postgres.model.UserPostgres;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserPostgresRepository extends CrudRepository<UserPostgres, Long> {

    List<UserPostgres> findAll();

}
