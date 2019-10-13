package org.csu.jpetstore.web.servlets;

import org.apache.log4j.Logger;
import org.csu.jpetstore.domain.Account;
import org.csu.jpetstore.domain.Item;
import org.csu.jpetstore.domain.Product;
import org.csu.jpetstore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ProductServlet extends HttpServlet {
    private static final String PRODUCT = "/WEB-INF/jsp/catalog/Product.jsp";
    private CatalogService catalogService;
    private static Logger logger = Logger.getLogger(Log4JInitServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        catalogService = new CatalogService();
        String id = req.getParameter("id");
        List<Item> itemList = catalogService.getItemListByProduct(id);
        Product product = catalogService.getProduct(id);
        req.setAttribute("itemList", itemList);
        req.setAttribute("product", product);
        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");
        String username = (account==null)?"":account.getUsername();
        logger.info(String.format("用户:%s 浏览了product:%s", username, product.getName()));
        req.getRequestDispatcher(PRODUCT).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
