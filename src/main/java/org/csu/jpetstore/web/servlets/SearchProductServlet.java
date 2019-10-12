package org.csu.jpetstore.web.servlets;

import org.csu.jpetstore.domain.Product;
import org.csu.jpetstore.service.CatalogService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SearchProductServlet extends HttpServlet {
    private static final String MAIN = "/WEB-INF/jsp/catalog/Main.jsp";
    private static final String SEARCH_PRODUCTS = "/WEB-INF/jsp/catalog/SearchProducts.jsp";
    CatalogService catalogService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(SEARCH_PRODUCTS).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        catalogService = new CatalogService();
        String keyword = req.getParameter("keyword").toString();
        if (keyword == null || keyword.length() < 1) {
            req.setAttribute("searchMsg", "请输入关键字");
            req.getRequestDispatcher(MAIN).forward(req, resp);
        } else {
            List<Product> productList = catalogService.searchProductList(keyword.toLowerCase());
            req.setAttribute("productList", productList);
            req.getRequestDispatcher(SEARCH_PRODUCTS).forward(req, resp);
        }
    }
}
