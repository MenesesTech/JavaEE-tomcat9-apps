package com.menesestech.webapp.headers.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login", "/login.html"})
public class LoginServlet extends HttpServlet {

    final static String USERNAME = "admin@gmail.com";
    final static String PASSWORD = "12345";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies() != null ? req.getCookies() : new Cookie[0];
        Optional<String> cookieOptional = Arrays.stream(cookies)
                .filter(c -> "username".equals(c.getName()))
                .map(Cookie::getValue)
                .findAny();
        if (cookieOptional.isPresent()) {
            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\">");
                out.println("<title>Hola" + cookieOptional.get() + "</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Hola" + cookieOptional.get() + " y has iniciado sesion anteriormente</h1>");
                out.println("</body>");
                out.println("</html>");
            }
        } else {
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            Cookie usernameCookie = new Cookie("username", username);
            response.addCookie(usernameCookie);

            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\">");
                out.println("<title>Iniciar Sesión</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Login correcto!</h1>");
                out.println("<h3>Hola " + username + " has iniciado sesion con exito!</h3>");
                out.println("</body>");
                out.println("</html>");
            }
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos no esta autorizado a ingresar a esta pagina!!");
        }
    }

}
