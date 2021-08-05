package com.jss2.jss2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private String login = "/WEB-INF/login.jsp";
    private String welcome = "/WEB-INF/welcome.jsp";

    private String username = "melih";
    private String password = "1234";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher(login).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (this.username.equals(username) && this.password.equals(password)) {
            req.setAttribute("username", username);
            req.getRequestDispatcher(welcome).forward(req, resp);
            return;
        }

        req.setAttribute("message", "Kullanıcı adı veya şifre hatalıdır.");
        req.getRequestDispatcher(login).forward(req, resp);
    }
}
