package org.csu.jpetstore.web.servlets.order;

import org.csu.jpetstore.domain.Account;
import org.csu.jpetstore.domain.Cart;
import org.csu.jpetstore.domain.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class NewOrderFormServlet extends HttpServlet {
    private static final String CART = "/WEB-INF/jsp/cart/Cart.jsp";
    private static final String NEW_ORDER = "/WEB-INF/jsp/order/NewOrderForm.jsp";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        Account account = (Account) session.getAttribute("account");
        Boolean authenticated = (Boolean) session.getAttribute("authenticated");
        if(account == null || !authenticated){
            req.setAttribute("msg", "请登录后再结账!");
            req.getRequestDispatcher(CART).forward(req, resp);
        }else if(cart != null){
            Order order = new Order();
            order.initOrder(account, cart);
            session.setAttribute("order", order);
//            req.setAttribute("order", order);
            req.getRequestDispatcher(NEW_ORDER).forward(req, resp);
        }else{
            req.setAttribute("msg", "遇到了一点错误,请重新登录!");
            req.getRequestDispatcher(CART).forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
