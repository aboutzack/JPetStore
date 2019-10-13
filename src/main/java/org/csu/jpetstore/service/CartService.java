package org.csu.jpetstore.service;

import org.csu.jpetstore.domain.Account;
import org.csu.jpetstore.domain.Cart;
import org.csu.jpetstore.persistence.CartDAO;
import org.csu.jpetstore.persistence.impl.CartDAOImpl;

public class CartService {
    private CartDAO cartDAO;

    public void insertCartItem(Account account, Cart cart){
        cartDAO = new CartDAOImpl();
        try {
            cartDAO.insertOrUpdateCart(account, cart);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Cart getCartByUsername(Account account) {
        cartDAO = new CartDAOImpl();
        try {
            return cartDAO.getCartByUsername(account);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public void deleteByUsernameAndItemId(Account account, String itemId) {
        cartDAO = new CartDAOImpl();
        try {
            cartDAO.deleteByUsernameAndItemId(account, itemId);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void deleteByUsername(Account account) {
        cartDAO = new CartDAOImpl();
        try {
            cartDAO.deleteByUsername(account);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
