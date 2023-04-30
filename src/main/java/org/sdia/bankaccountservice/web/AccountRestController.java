package org.sdia.bankaccountservice.web;

import org.sdia.bankaccountservice.Sirvice.AccountService;
import org.sdia.bankaccountservice.dto.BankAccountRequestDTO;
import org.sdia.bankaccountservice.dto.BankAccountResponseDTO;
import org.sdia.bankaccountservice.entities.BankAccount;
import org.sdia.bankaccountservice.mapers.AccountMaper;
import org.sdia.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
//@RequestMapping("/api")
public class AccountRestController {
      private BankAccountRepository bankAccountRepository;

      private AccountService accountService;
      private AccountMaper accountMaper;


    public AccountRestController(BankAccountRepository bankAccountRepository, AccountService accountService, AccountMaper accountMaper) {
        this.bankAccountRepository = bankAccountRepository;
        this.accountService = accountService;
        this.accountMaper = accountMaper;
    }
    @GetMapping("/bankAccounts")
    public List<BankAccount> bankAccounts(){
        return bankAccountRepository.findAll();
    }
    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id){
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }
    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO requestDTO){

        return accountService.AddAcount(requestDTO);
    }
    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id,@RequestBody BankAccount objetBankAccount){
        BankAccount account=bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
        if (objetBankAccount.getBalance()!=null)account.setBalance(objetBankAccount.getBalance());
        if (objetBankAccount.getType()!=null)account.setType(objetBankAccount.getType());
        if (objetBankAccount.getCurrency()!=null)account.setCurrency(objetBankAccount.getCurrency());
        if (objetBankAccount.getCreatedAt()!=null)account.setCreatedAt(new Date());
        return bankAccountRepository.save(account);
    }
    @DeleteMapping("/bankAccounts/{id}")
    public void deleteBankAccount(@PathVariable String id){
        bankAccountRepository.deleteById(id);
    }
}
