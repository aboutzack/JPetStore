package org.csu.jpetstore.persistence;

import org.csu.jpetstore.domain.Account;
import org.csu.jpetstore.domain.Cart;

public interface CartDAO {
    void insertOrUpdateCart(Account account, Cart cart) throws Exception;
    Cart getCartByUsername(Account account) throws Exception;
    void deleteByUsernameAndItemId(Account account, String itemId) throws Exception;
    void deleteByUsername(Account account) throws Exception;
}
