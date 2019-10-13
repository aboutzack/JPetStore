package org.csu.jpetstore.web.servlets;

import com.wf.captcha.utils.CaptchaUtil;
import org.csu.jpetstore.domain.Account;
import org.csu.jpetstore.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SignInServlet extends HttpServlet {
    private static final String SIGN_IN = "/WEB-INF/jsp/account/SignonForm.jsp";
    private AccountService accountService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(SIGN_IN).forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String captcha = req.getParameter("captcha");
        accountService = new AccountService();
        Account account = accountService.getAccount(username, password);
        if(!CaptchaUtil.ver(captcha, req)){
            CaptchaUtil.clear(req);
            req.setAttribute("msg", "验证码错误!");
            req.getRequestDispatcher(SIGN_IN).forward(req, resp);
        }
        else if(account == null){
            req.setAttribute("msg", "用户名或密码错误");
            req.getRequestDispatcher(SIGN_IN).forward(req, resp);
        }else{
            HttpSession session = req.getSession();
            session.setAttribute("authenticated", true);
            session.setAttribute("account", account);
            resp.sendRedirect("/main");
        }
    }
}
