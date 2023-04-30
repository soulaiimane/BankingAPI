package org.sdia.bankaccountservice.web;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sdia.bankaccountservice.Sirvice.AccountService;
import org.sdia.bankaccountservice.Sirvice.AccountServiceImpl;
import org.sdia.bankaccountservice.dto.BankAccountRequestDTO;
import org.sdia.bankaccountservice.dto.BankAccountResponseDTO;
import org.sdia.bankaccountservice.entities.BankAccount;
import org.sdia.bankaccountservice.entities.Customer;
import org.sdia.bankaccountservice.enums.AccountType;
import org.sdia.bankaccountservice.repositories.BankAccountRepository;
import org.sdia.bankaccountservice.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class AccountGraphQLController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private CustomerRepository customerRepository;
   @Autowired
    private AccountService accountService;
    @QueryMapping
    public List<BankAccount> accountsList(){
       return bankAccountRepository.findAll();
    }
@QueryMapping
    public BankAccount BankAccountById(@Argument String id){
        return bankAccountRepository.findById(id)
                .orElseThrow(()->new RuntimeException(String.format("Account with id=%s Not Found Try Again",id)));
    }
    @MutationMapping
    public BankAccountResponseDTO  addAccount(@Argument BankAccountRequestDTO bankAccount){
        return accountService.AddAcount(bankAccount);


    }
    @MutationMapping
    public BankAccountResponseDTO  updateAccount(@Argument String id,@Argument BankAccountRequestDTO bankAccount){
        return accountService.updateAccount(id,bankAccount);


    }
    @MutationMapping
    public Boolean   deleteAccount(@Argument String id){
       accountService.deleteAccount(id);
       return true;
    }
    @QueryMapping
    public List<Customer> customers(){
       return  customerRepository.findAll();

    }

}
