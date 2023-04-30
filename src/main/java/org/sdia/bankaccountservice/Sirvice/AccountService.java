package org.sdia.bankaccountservice.Sirvice;

import org.sdia.bankaccountservice.dto.BankAccountRequestDTO;
import org.sdia.bankaccountservice.dto.BankAccountResponseDTO;

public interface AccountService {
    public BankAccountResponseDTO AddAcount(BankAccountRequestDTO bankAccountRequestDTO );

    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountRequestDTO);

    boolean deleteAccount(String id);
}
