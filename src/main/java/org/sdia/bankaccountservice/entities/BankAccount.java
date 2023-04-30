package org.sdia.bankaccountservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sdia.bankaccountservice.enums.AccountType;

import java.util.Date;

@Entity
@Data // giters and siters
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccount {
    @Id
    private String id;
    private Date createdAt;
    private  Double balance;
    private String currency;
    @Enumerated (EnumType.STRING)
    private AccountType type;
    @ManyToOne
    private Customer customer;
}
