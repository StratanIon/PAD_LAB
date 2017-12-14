package md.utm.repository;

import md.utm.model.Account;

import java.util.List;

public interface AccountRepository {
    void save(Account account);
    Account getAccount(int id);
    List<Account> getAllAccounts();
}
