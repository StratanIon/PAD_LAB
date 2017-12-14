package md.utm.controller;

import md.utm.model.Account;
import md.utm.model.Apartment;
import md.utm.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class AccountController {

    private AccountRepository accountRepository;

    @Autowired
    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @RequestMapping(value = "/accounts")
    public List<Account> getAllAccounts() {
        return accountRepository.getAllAccounts();
    }

    @RequestMapping(value = "/accounts/{id}")
    public Account getAccountById(@PathVariable("id") int id) {
        return accountRepository.getAccount(id);
    }

    @RequestMapping(value = "/accounts", method = RequestMethod.POST)
    public void insertAccount(@RequestBody Account account) {
        accountRepository.save(account);
    }
}
