package com.tickets.tickets.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document("tickets")
public class Ticket {

    @Id
    private String id;
    private User user;
    private Event event;
    private Integer place;
    private Category category;

}
