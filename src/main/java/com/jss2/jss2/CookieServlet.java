package com.jss2.jss2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet("/cookie")
public class CookieServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("display") != null) {
            Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                PrintWriter writer = resp.getWriter();
                for (Cookie cookie : cookies) {
                    writer.println("Cookie Name: " + cookie.getName() + " Cookie Value: " + cookie.getValue());
                }
            }
        } else {
            Cookie cookie = new Cookie("obss_" + LocalDateTime.now().getNano(), "jss");
            cookie.setHttpOnly(true);
            resp.addCookie(cookie);
            resp.getWriter().println("Cookie added.");

        }
    }
}
