package com.csc340sp23.Account;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Christopher Jacobs
 */
@Service
public class AccountService {
    
    @Autowired
    private AccountRepository repo;

    public List<Account> getAllAccounts() {
        return repo.findAll();
    }

    public Account getAccount(long accountId) {
        return repo.getReferenceById(accountId);
    }

    public void deleteAccount(long accountId) {
        repo.deleteById(accountId);
    }

    void saveAccount(Account account) {

        repo.save(account);
    }
}
