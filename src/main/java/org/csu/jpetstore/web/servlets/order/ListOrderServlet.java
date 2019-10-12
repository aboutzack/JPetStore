package org.csu.jpetstore.web.servlets.order;

import org.csu.jpetstore.domain.Account;
import org.csu.jpetstore.domain.Order;
import org.csu.jpetstore.service.OrderService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ListOrderServlet extends HttpServlet {
    private static final String LIST_ORDER = "/WEB-INF/jsp/order/ListOrders.jsp";
    private OrderService orderService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        orderService = new OrderService();
        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");
        List<Order> orderList = orderService.getOrdersByUsername(account.getUsername());
        session.setAttribute("orderList", orderList);
        req.getRequestDispatcher(LIST_ORDER).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
