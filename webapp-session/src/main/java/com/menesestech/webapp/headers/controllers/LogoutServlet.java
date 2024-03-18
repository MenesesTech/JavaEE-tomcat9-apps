package com.menesestech.webapp.headers.controllers;

import com.menesestech.webapp.headers.services.LoginService;
import com.menesestech.webapp.headers.services.LoginServiceSessionImpl;
import java.io.IOException;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Logout", urlPatterns = {"/logout"})
public class LogoutServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LoginService auth = new LoginServiceSessionImpl();
        Optional<String> username = auth.getUsername(request);
        if (username.isPresent()) {
            HttpSession session = request.getSession();
            session.invalidate();
        }
        response.sendRedirect(request.getContextPath()+"/login.html");
    }
}
