package com.tickets.tickets.postgres.repository;

import com.tickets.tickets.postgres.model.EventPostgres;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventPostgresRepository extends CrudRepository<EventPostgres, Long> {
    List<EventPostgres> findAll();

}
