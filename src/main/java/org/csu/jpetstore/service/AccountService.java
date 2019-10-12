package org.csu.jpetstore.service;

import org.csu.jpetstore.domain.Account;
import org.csu.jpetstore.persistence.AccountDAO;
import org.csu.jpetstore.persistence.impl.AccountDAOImpl;

public class AccountService {
    private AccountDAO accountDAO;

    public Account getAccount(String username) {
        accountDAO = new AccountDAOImpl();
        try {
            return accountDAO.getAccountByUsername(username);
        }catch (Exception ex){
            return null;
        }
    }

    public Account getAccount(String username, String password) {
        accountDAO = new AccountDAOImpl();
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        try {
            return accountDAO.getAccountByUsernameAndPassword(account);
        }catch (Exception ex){
            return null;
        }
    }

    public void insertAccount(Account account) {
        accountDAO = new AccountDAOImpl();
        try {
            accountDAO.insertAccount(account);
            accountDAO.insertProfile(account);
            accountDAO.insertSignon(account);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void updateAccount(Account account) {
        accountDAO = new AccountDAOImpl();
        try {
            accountDAO.updateAccount(account);
            accountDAO.updateProfile(account);
            accountDAO.updateSignon(account);
        }catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
