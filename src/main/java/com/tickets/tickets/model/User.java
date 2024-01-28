package com.tickets.tickets.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * The type User.
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Document("users")
public class User {

    @Id
    private String id;
    private String name;
    private String email;
    private BigDecimal userAccount;

    @DBRef
    @Builder.Default
    private List<Ticket> tickets = new ArrayList<>();


}

