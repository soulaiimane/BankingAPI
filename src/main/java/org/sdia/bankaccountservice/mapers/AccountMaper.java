package org.sdia.bankaccountservice.mapers;

import com.fasterxml.jackson.databind.util.BeanUtil;
import org.sdia.bankaccountservice.dto.BankAccountResponseDTO;
import org.sdia.bankaccountservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMaper {
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){
        BankAccountResponseDTO responseDTO=new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount,responseDTO);
        return responseDTO;
    }
}
