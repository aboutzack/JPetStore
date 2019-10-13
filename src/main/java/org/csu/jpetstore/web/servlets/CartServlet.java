package org.csu.jpetstore.web.servlets;

import org.apache.log4j.Logger;
import org.csu.jpetstore.domain.Account;
import org.csu.jpetstore.domain.Cart;
import org.csu.jpetstore.domain.Item;
import org.csu.jpetstore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class CartServlet extends HttpServlet {
    private static final String CART = "/WEB-INF/jsp/cart/Cart.jsp";
    private CatalogService catalogService;
    private static Logger logger = Logger.getLogger(Log4JInitServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(CART).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        catalogService = new CatalogService();
        String itemId = req.getParameter("itemId");
        Cart cart;
        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");
        String username = (account==null)?"":account.getUsername();
        if(session.getAttribute("cart")!=null){
            cart = (Cart) session.getAttribute("cart");
        }else {
            cart = new Cart();
        }
        if (cart.containsItemId(itemId)) {
            cart.incrementQuantityByItemId(itemId);
        } else {
            boolean isInStock = catalogService.isItemInStock(itemId);
            Item item = catalogService.getItem(itemId);
            cart.addItem(item, isInStock);
        }
        session.setAttribute("cart", cart);
        //持久化到数据库
        logger.info(String.format("用户:%s 添加 item:%s 到购物车", username, itemId));
        resp.sendRedirect("/cart");
    }
}
