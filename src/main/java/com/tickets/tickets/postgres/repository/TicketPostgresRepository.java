package com.tickets.tickets.postgres.repository;

import com.tickets.tickets.postgres.model.TicketPostgres;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketPostgresRepository extends CrudRepository<TicketPostgres, Long> {

    List<TicketPostgres> findAll();

}
