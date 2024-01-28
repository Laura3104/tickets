package com.tickets.tickets.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;


import java.math.BigDecimal;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserAccount {

    @Id
    private String id;
    private User user;
    private BigDecimal money;

}
