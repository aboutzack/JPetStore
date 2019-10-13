package org.csu.jpetstore.web.servlets;

import org.apache.log4j.Logger;
import org.csu.jpetstore.domain.Account;
import org.csu.jpetstore.domain.Cart;
import org.csu.jpetstore.domain.Item;
import org.csu.jpetstore.service.CartService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class RemoveItemServlet extends HttpServlet {
    private static Logger logger = Logger.getLogger(Log4JInitServlet.class);
    private CartService cartService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        cartService = new CartService();
        String id = req.getParameter("id").toString();
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        Item item = cart.removeItemById(id);
        Account account = (Account) session.getAttribute("account");
        String username = (account==null)?"":account.getUsername();
        logger.info(String.format("用户:%s 删除 item:%s 从购物车", username, id));
        //持久化到数据库
        cartService.deleteByUsernameAndItemId(account, item.getItemId());
        resp.sendRedirect("/cart");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
