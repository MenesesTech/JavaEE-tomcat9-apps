package com.menesestech.webapp.headers.controllers;

import com.menesestech.webapp.headers.services.LoginService;
import com.menesestech.webapp.headers.services.LoginServiceImpl;
import java.io.IOException;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Logout", urlPatterns = {"/logout"})
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LoginService auth = new LoginServiceImpl();
        Optional<String> username = auth.getUsername(request);
        if (username.isPresent()) {
            Cookie usernameCookie = new Cookie("username", "");
            usernameCookie.setMaxAge(0);
            response.addCookie(usernameCookie);
        }
        response.sendRedirect(request.getContextPath()+"/login.html");
    }
}
