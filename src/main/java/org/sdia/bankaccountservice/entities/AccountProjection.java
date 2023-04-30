package org.sdia.bankaccountservice.entities;

import org.springframework.data.rest.core.config.Projection;

import java.awt.*;
@Projection(types = BankAccount.class,name = "p1")
public interface AccountProjection {
    public String getId();
    public Double getBalance();
    public String getCurrency();
}
