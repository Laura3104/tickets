package com.tickets.tickets.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document("events")
public class Event {

    @Id
    private String id;
    private String title;
    private Date date;
    private BigDecimal ticketPrice;

    @DBRef
    @Builder.Default
    private List<Ticket> tickets = new ArrayList<>();

}
