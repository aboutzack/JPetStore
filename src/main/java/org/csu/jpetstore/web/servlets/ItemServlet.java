package org.csu.jpetstore.web.servlets;

import org.csu.jpetstore.domain.Item;
import org.csu.jpetstore.domain.Product;
import org.csu.jpetstore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ItemServlet extends HttpServlet {
    private static final String ITEM = "/WEB-INF/jsp/catalog/Item.jsp";
    private CatalogService catalogService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        catalogService = new CatalogService();
        String id = req.getParameter("id");
        Item item =  catalogService.getItem(id);
        Product product = item.getProduct();
        req.setAttribute("item", item);
        req.setAttribute("product", product);
        req.getRequestDispatcher(ITEM).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
