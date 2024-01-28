package com.tickets.tickets.service;

import com.tickets.tickets.model.Event;
import com.tickets.tickets.model.Ticket;
import com.tickets.tickets.model.User;
import com.tickets.tickets.postgres.model.EventPostgres;
import com.tickets.tickets.postgres.model.TicketPostgres;
import com.tickets.tickets.postgres.model.UserPostgres;
import com.tickets.tickets.postgres.repository.EventPostgresRepository;
import com.tickets.tickets.postgres.repository.TicketPostgresRepository;
import com.tickets.tickets.postgres.repository.UserPostgresRepository;
import com.tickets.tickets.repository.EventRepository;
import com.tickets.tickets.repository.TicketRepository;
import com.tickets.tickets.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataMigrationService {

    private final EventPostgresRepository eventPostgresRepository;
    private final TicketPostgresRepository ticketPostgresRepository;
    private final UserPostgresRepository userPostgresRepository;
    private final EventRepository eventRepository;
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

    public DataMigrationService(EventPostgresRepository eventPostgresRepository,
                                TicketPostgresRepository ticketPostgresRepository,
                                UserPostgresRepository userPostgresRepository, EventRepository eventRepository,
                                TicketRepository ticketRepository, UserRepository userRepository) {
        this.eventPostgresRepository = eventPostgresRepository;
        this.ticketPostgresRepository = ticketPostgresRepository;
        this.userPostgresRepository = userPostgresRepository;
        this.eventRepository = eventRepository;
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }

    public void migrateData(){

        List<EventPostgres> postgresEvents = eventPostgresRepository.findAll();

        for (EventPostgres eventPostgres : postgresEvents) {
            Event event = Event.builder()
                    .title(eventPostgres.getTitle())
                    .date(eventPostgres.getDate())
                    .ticketPrice(eventPostgres.getTicketPrice())
                    .build();
            eventRepository.save(event);
        }

        List<TicketPostgres> postgresTickets = ticketPostgresRepository.findAll();

        for(TicketPostgres ticketPostgres : postgresTickets) {

            EventPostgres eventPostgres = ticketPostgres.getEvent();

            Event event = Event.builder()
                    .title(eventPostgres.getTitle())
                    .date(eventPostgres.getDate())
                    .ticketPrice(eventPostgres.getTicketPrice())
                    .build();

            UserPostgres userPostgres = ticketPostgres.getUser();

            User user = User.builder()
                    .email(userPostgres.getEmail())
                    .name(userPostgres.getName())
                    .build();

            Ticket ticket = Ticket.builder()
                    .user(user).event(event)
                    .category(ticketPostgres.getCategory())
                    .place(ticketPostgres.getPlace()).build();

            ticketRepository.save(ticket);

        }

        List<UserPostgres> postgresUsers = userPostgresRepository.findAll();

        for(UserPostgres userPostgres : postgresUsers){
            User user = User.builder()
                    .name(userPostgres.getName())
                    .email(userPostgres.getName())
                    .userAccount(userPostgres.getUserAccount().getMoney()).build();
            userRepository.save(user);
        }

        System.out.println("All data migrated");
    }
}
