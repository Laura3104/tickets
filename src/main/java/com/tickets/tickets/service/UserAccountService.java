package com.tickets.tickets.service;

import com.tickets.tickets.model.UserAccount;

import java.math.BigDecimal;

public interface UserAccountService {

    UserAccount refillAccount(String userId, BigDecimal money);
}
