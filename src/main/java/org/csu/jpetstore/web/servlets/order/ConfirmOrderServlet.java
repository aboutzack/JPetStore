package org.csu.jpetstore.web.servlets.order;

import org.apache.log4j.Logger;
import org.csu.jpetstore.domain.Account;
import org.csu.jpetstore.domain.Order;
import org.csu.jpetstore.service.CartService;
import org.csu.jpetstore.service.OrderService;
import org.csu.jpetstore.web.servlets.Log4JInitServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class ConfirmOrderServlet extends HttpServlet {
    private OrderService orderService;
    private CartService cartService;
    private static final String VIEW_ORDER = "/WEB-INF/jsp/order/ViewOrder.jsp";
    private static final String SHIPPING = "/WEB-INF/jsp/order/ShippingForm.jsp";
    private static Logger logger = Logger.getLogger(Log4JInitServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        orderService = new OrderService();
        cartService = new CartService();
        HttpSession session = req.getSession();
        String shippingAddressRequired  = req.getParameter("shippingAddressRequired");
        Order order = (Order) session.getAttribute("order");
        if (shippingAddressRequired != null) {
            req.getRequestDispatcher(SHIPPING).forward(req, resp);
        }
        else if (order != null) {
            //判断是否填写了收货地表单
            if(req.getParameter("shipToFirstName")!=null){
                String shipToFirstName = req.getParameter("shipToFirstName");
                String shipToLastName = req.getParameter("shipToLastName");
                String shipAddress1 = req.getParameter("shipAddress1");
                String shipAddress2 = req.getParameter("shipAddress2");
                String shipCity = req.getParameter("shipCity");
                String shipState = req.getParameter("shipState");
                String shipZip = req.getParameter("shipZip");
                String shipCountry = req.getParameter("shipCountry");
                order.setShipToFirstName(shipToFirstName);
                order.setShipToLastName(shipToLastName);
                order.setShipAddress1(shipAddress1);
                order.setShipAddress2(shipAddress2);
                order.setShipCity(shipCity);
                order.setShipState(shipState);
                order.setShipZip(shipZip);
                order.setShipCountry(shipCountry);
            }
            orderService.insertOrder(order);
            //清空购物车
            session.setAttribute("cart", null);
            Account account = (Account) session.getAttribute("account");
            cartService.deleteByUsername(account);
            logger.info(String.format("用户:%s 生成订单 订单号:%d", order.getUsername(), order.getOrderId()));
            req.getRequestDispatcher(VIEW_ORDER).forward(req, resp);
        }
    }
}
