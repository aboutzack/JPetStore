package org.csu.jpetstore.persistence.impl;

import org.csu.jpetstore.domain.Account;
import org.csu.jpetstore.persistence.AccountDAO;
import org.csu.jpetstore.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AccountDAOImpl implements AccountDAO {
    private static String getAccountByUsernameSQL = "select " +
            "signon.username," +
            "account.email," +
            "account.firstname," +
            "account.lastname," +
            "account.status," +
            "account.addr1 as address1," +
            "account.addr2 as address2," +
            "account.city," +
            "account.state," +
            "account.zip," +
            "account.country," +
            "account.phone," +
            "profile.langpref as languagepreference," +
            "profile.favcategory as favouritecategoryid," +
            "profile.mylistopt as listoption," +
            "profile.banneropt as banneroption," +
            "bannerdata.bannername" +
            "from account, profile, signon, bannerdata " +
            "where account.userid = ? " +
            "and signon.username = account.userid " +
            "and profile.userid = account.userid " +
            "and profile.favcategory = bannerdata.favcategory ";
    private static String getAccountByUsernameAndPasswordSQL = "select " +
            "signon.username," +
            "account.email," +
            "account.firstname," +
            "account.lastname," +
            "account.status," +
            "account.addr1 as address1," +
            "account.addr2 as address2," +
            "account.city," +
            "account.state," +
            "account.zip," +
            "account.country," +
            "account.phone," +
            "profile.langpref as languagepreference," +
            "profile.favcategory as favouritecategoryid," +
            "profile.mylistopt as listoption," +
            "profile.banneropt as banneroption," +
            "bannerdata.bannername " +
            "from account, profile, signon, bannerdata " +
            "where account.userid = ? " +
            "and signon.password = ? " +
            "and signon.username = account.userid " +
            "and profile.userid = account.userid " +
            "and profile.favcategory = bannerdata.favcategory ";
    private static String insertAccountSQL = "insert into account " +
            "(email, firstname, lastname, status, addr1, addr2, city, state, zip, country, phone, userid) " +
            "values" +
            "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static String insertProfileSQL = "insert into profile (langpref, favcategory, userid, mylistopt, banneropt) " +
            "values (?, ?, ?, ?, ?)";
    private static String insertSignonSQL = "insert into signon (password,username) " +
            "values (?, ?)";
    private static String updateAccountSQL = "update account set " +
            "email = ?," +
            "firstname = ?," +
            "lastname = ?," +
            "status = ?," +
            "addr1 = ?," +
            "addr2 = ?," +
            "city = ?," +
            "state = ?," +
            "zip = ?," +
            "country = ?," +
            "phone = ? " +
            "where userid = ?";
    private static String updateProfileSQL = "update profile set " +
            "langpref = ?," +
            "favcategory = ? " +
            "where userid = ?";
    private static String updateSignonSQL = "update signon set password = ? " +
            "where username = ?";


    @Override
    public Account getAccountByUsername(String username) throws Exception{
        Connection connection = DBUtil.getConnection();
        PreparedStatement pStatement = connection.prepareStatement(getAccountByUsernameSQL);
        pStatement.setString(1, username);
        ResultSet resultSet = pStatement.executeQuery();
        Account account = new Account();
        if (resultSet.next()) {
            account.setUsername(resultSet.getString("username"));
            account.setEmail(resultSet.getString("email"));
            account.setFirstName(resultSet.getString("firstname"));
            account.setLastName(resultSet.getString("lastname"));
            account.setStatus(resultSet.getString("status"));
            account.setAddr1(resultSet.getString("address1"));
            account.setAddr2(resultSet.getString("address2"));
            account.setCity(resultSet.getString("city"));
            account.setState(resultSet.getString("state"));
            account.setZip(resultSet.getString("zip"));
            account.setCountry(resultSet.getString("country"));
            account.setPhone(resultSet.getString("phone"));
            account.setLanguagePreference(resultSet.getString("languagePreference"));
            account.setFavouriteCategoryId(resultSet.getString("favouritecategoryid"));
            account.setListOption(resultSet.getBoolean("listOption"));
            account.setBannerOption(resultSet.getBoolean("bannerOption"));
            account.setBannerName(resultSet.getString("bannername"));
        }
        DBUtil.closeConnection(connection);
        return account;
    }

    @Override
    public Account getAccountByUsernameAndPassword(Account account) throws Exception {
        Connection connection = DBUtil.getConnection();
        PreparedStatement pStatement = connection.prepareStatement(getAccountByUsernameAndPasswordSQL);
        pStatement.setString(1, account.getUsername());
        pStatement.setString(2, account.getPassword());
        ResultSet resultSet = pStatement.executeQuery();
        Account account1 = new Account();
        if (resultSet.next()) {
            account1.setUsername(resultSet.getString("username"));
            account1.setEmail(resultSet.getString("email"));
            account1.setFirstName(resultSet.getString("firstname"));
            account1.setLastName(resultSet.getString("lastname"));
            account1.setStatus(resultSet.getString("status"));
            account1.setAddr1(resultSet.getString("address1"));
            account1.setAddr2(resultSet.getString("address2"));
            account1.setCity(resultSet.getString("city"));
            account1.setState(resultSet.getString("state"));
            account1.setZip(resultSet.getString("zip"));
            account1.setCountry(resultSet.getString("country"));
            account1.setPhone(resultSet.getString("phone"));
            account1.setLanguagePreference(resultSet.getString("languagePreference"));
            account1.setFavouriteCategoryId(resultSet.getString("favouritecategoryid"));
            account1.setListOption(resultSet.getBoolean("listOption"));
            account1.setBannerOption(resultSet.getBoolean("bannerOption"));
            account1.setBannerName(resultSet.getString("bannername"));
            DBUtil.closeConnection(connection);
            return account1;
        }else{
            DBUtil.closeConnection(connection);
            return null;
        }
    }

    @Override
    public void insertAccount(Account account) throws Exception {
        Connection connection = DBUtil.getConnection();
        PreparedStatement pStatement = connection.prepareStatement(insertAccountSQL);
        pStatement.setString(1, account.getEmail());
        pStatement.setString(2, account.getFirstName());
        pStatement.setString(3, account.getLastName());
        pStatement.setString(4, account.getStatus());
        pStatement.setString(5, account.getAddr1());
        pStatement.setString(6, account.getAddr2());
        pStatement.setString(7, account.getCity());
        pStatement.setString(8, account.getState());
        pStatement.setString(9, account.getZip());
        pStatement.setString(10, account.getCountry());
        pStatement.setString(11, account.getPhone());
        pStatement.setString(12, account.getUsername());

        pStatement.executeUpdate();
        DBUtil.closeConnection(connection);
    }

    @Override
    public void insertProfile(Account account) throws Exception {
        Connection connection = DBUtil.getConnection();
        PreparedStatement pStatement = connection.prepareStatement(insertProfileSQL);
        pStatement.setString(1, account.getLanguagePreference());
        pStatement.setString(2, account.getFavouriteCategoryId());
        pStatement.setString(3, account.getUsername());
        pStatement.setInt(4, account.isListOption()?1:0);
        pStatement.setInt(5, account.isBannerOption()?1:0);

        pStatement.executeUpdate();
        DBUtil.closeConnection(connection);
    }

    @Override
    public void insertSignon(Account account) throws Exception {
        Connection connection = DBUtil.getConnection();
        PreparedStatement pStatement = connection.prepareStatement(insertSignonSQL);
        pStatement.setString(1, account.getPassword());
        pStatement.setString(2, account.getUsername());

        pStatement.executeUpdate();
        DBUtil.closeConnection(connection);
    }

    @Override
    public void updateAccount(Account account) throws Exception {
        Connection connection = DBUtil.getConnection();
        PreparedStatement pStatement = connection.prepareStatement(updateAccountSQL);
        pStatement.setString(1, account.getEmail());
        pStatement.setString(2, account.getFirstName());
        pStatement.setString(3, account.getLastName());
        pStatement.setString(4, account.getStatus());
        pStatement.setString(5, account.getAddr1());
        pStatement.setString(6, account.getAddr2());
        pStatement.setString(7, account.getCity());
        pStatement.setString(8, account.getState());
        pStatement.setString(9, account.getZip());
        pStatement.setString(10, account.getCountry());
        pStatement.setString(11, account.getPhone());
        pStatement.setString(12, account.getUsername());

        pStatement.executeUpdate();
        DBUtil.closeConnection(connection);
    }

    @Override
    public void updateProfile(Account account) throws Exception {
        Connection connection = DBUtil.getConnection();
        PreparedStatement pStatement = connection.prepareStatement(updateProfileSQL);
        pStatement.setString(1, account.getLanguagePreference());
        pStatement.setString(2, account.getFavouriteCategoryId());
        pStatement.setString(3, account.getUsername());

        pStatement.executeUpdate();
        DBUtil.closeConnection(connection);
    }

    @Override
    public void updateSignon(Account account) throws Exception {
        Connection connection = DBUtil.getConnection();
        PreparedStatement pStatement = connection.prepareStatement(updateSignonSQL);
        pStatement.setString(1, account.getPassword());
        pStatement.setString(2, account.getUsername());

        pStatement.executeUpdate();
        DBUtil.closeConnection(connection);
    }
}
