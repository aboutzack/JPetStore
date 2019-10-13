package org.csu.jpetstore.web.servlets;

import org.csu.jpetstore.domain.Account;
import org.csu.jpetstore.domain.Cart;
import org.csu.jpetstore.domain.CartItem;
import org.csu.jpetstore.service.CartService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Iterator;

public class UpdateCartServlet extends HttpServlet {
    private static final String VIEW_CART = "/WEB-INF/jsp/cart/Cart.jsp";
    private CartService cartService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        cartService = new CartService();
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        Iterator<CartItem> cartItems = cart.getAllCartItems();
        while (cartItems.hasNext()) {
            CartItem cartItem = (CartItem) cartItems.next();
            String itemId = cartItem.getItem().getItemId();
            try {
                int quantity = Integer.parseInt(req.getParameter(itemId).toString());
                cart.setQuantityByItemId(itemId, quantity);
                if (quantity < 1) {
                    Account account = (Account) session.getAttribute("account");
                    //从数据库删除此条记录
                    cartService.deleteByUsernameAndItemId(account, cartItem.getItem().getItemId());
                    cartItems.remove();
                }
                Account account = (Account)session.getAttribute("account");
                cartService.insertCartItem(account, cart);
            } catch (Exception e) {
            }
        }
        resp.sendRedirect("/cart");
    }
}
