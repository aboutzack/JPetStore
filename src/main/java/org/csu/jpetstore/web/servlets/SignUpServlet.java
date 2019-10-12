package org.csu.jpetstore.web.servlets;

import org.csu.jpetstore.domain.Account;
import org.csu.jpetstore.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignUpServlet extends HttpServlet {
    private static final String SIGN_UP = "/WEB-INF/jsp/account/NewAccountForm.jsp";
    private AccountService accountService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(SIGN_UP).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String repeatedPassword = req.getParameter("repeatedPassword");
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String addr1 = req.getParameter("addr1");
        String addr2 = req.getParameter("addr2");
        String city = req.getParameter("city");
        String state = req.getParameter("state");
        String zip = req.getParameter("zip");
        String country = req.getParameter("country");
        String languagePreference = req.getParameter("languagePreference");
        String favoriteCategory = req.getParameter("favoriteCategory");
        boolean listOpt = !(req.getParameter("listOpt")==null);
        boolean bannerOpt = !(req.getParameter("bannerOpt")==null);
        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setFirstName(firstName);
        account.setLastName(lastName);
        account.setEmail(email);
        account.setPhone(phone);
        account.setAddr1(addr1);
        account.setAddr2(addr2);
        account.setCity(city);
        account.setState(state);
        account.setZip(zip);
        account.setCountry(country);
        account.setLanguagePreference(languagePreference);
        account.setFavouriteCategoryId(favoriteCategory);
        account.setListOption(listOpt);
        account.setBannerOption(bannerOpt);
        if(!password.equals(repeatedPassword)){
            req.setAttribute("msg", "两次输入的密码不一致!");
            req.getRequestDispatcher(SIGN_UP).forward(req, resp);
        }else {
            accountService = new AccountService();
            accountService.insertAccount(account);
        }
        resp.sendRedirect("/main");
    }
}
