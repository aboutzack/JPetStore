package org.csu.jpetstore.web.servlets;

import com.wf.captcha.GifCaptcha;
import com.wf.captcha.utils.CaptchaUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CaptchaServlet extends com.wf.captcha.servlet.CaptchaServlet {
    private static final long serialVersionUID = -90304944339413093L;

    public CaptchaServlet() {
        super();
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 使用gif验证码
        GifCaptcha gifCaptcha = new GifCaptcha(80,24,4);
        CaptchaUtil.out(gifCaptcha, request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
