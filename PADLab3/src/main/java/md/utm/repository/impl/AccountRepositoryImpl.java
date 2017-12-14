package md.utm.repository.impl;

import md.utm.model.Account;
import md.utm.repository.AccountRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class AccountRepositoryImpl implements AccountRepository {

    private final AtomicInteger atomicInteger = new AtomicInteger();

    private List<Account> accountList = new ArrayList<Account>(Arrays.asList(
            new Account(atomicInteger.incrementAndGet(), "Stratan"),
            new Account(atomicInteger.incrementAndGet(), "Braga"),
            new Account(atomicInteger.incrementAndGet(), "Petrenco")
    ));

    @Override
    public void save(Account account) {
        accountList.add(account);
    }

    @Override
    public Account getAccount(int id) {
        return accountList.stream().filter(account -> account.getId() == id).findFirst().get();
    }

    @Override
    public List<Account> getAllAccounts() {
        return accountList;
    }
}
