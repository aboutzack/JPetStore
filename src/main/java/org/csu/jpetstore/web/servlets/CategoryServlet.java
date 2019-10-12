package org.csu.jpetstore.web.servlets;

import org.csu.jpetstore.domain.Product;
import org.csu.jpetstore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CategoryServlet extends HttpServlet {
    public static final String CATEGORY = "/WEB-INF/jsp/catalog/Category.jsp";
    private CatalogService catalogService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        catalogService = new CatalogService();
        String id = req.getParameter("id");
        List<Product> productList = new ArrayList<>();
        productList = catalogService.getProductListByCategory(id);
        req.setAttribute("productList", productList);
        req.setAttribute("categoryId",id);
        req.getRequestDispatcher(CATEGORY).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
