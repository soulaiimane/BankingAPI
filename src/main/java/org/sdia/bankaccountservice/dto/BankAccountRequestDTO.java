package org.sdia.bankaccountservice.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sdia.bankaccountservice.enums.AccountType;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Date;
@Data   @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccountRequestDTO {
    private  Double balance;
    private String currency;
    private AccountType type;
}
