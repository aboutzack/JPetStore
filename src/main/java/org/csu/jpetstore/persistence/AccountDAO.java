package org.csu.jpetstore.persistence;

import org.csu.jpetstore.domain.Account;

public interface AccountDAO {
    Account getAccountByUsername(String username) throws Exception;

    Account getAccountByUsernameAndPassword(Account account) throws Exception;

    void insertAccount(Account account) throws Exception;

    void insertProfile(Account account) throws Exception;

    void insertSignon(Account account) throws Exception;

    void updateAccount(Account account) throws Exception;

    void updateProfile(Account account) throws Exception;

    void updateSignon(Account account) throws Exception;
}
