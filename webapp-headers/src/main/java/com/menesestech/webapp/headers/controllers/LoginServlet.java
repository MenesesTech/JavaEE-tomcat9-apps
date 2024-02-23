package com.menesestech.webapp.headers.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    final static String USERNAME = "admin@gmail.com";
    final static String PASSWORD = "12345";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
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
                out.println("<h3>Hola "+username+" has iniciado sesion con exito!</h3>");
                out.println("</body>");
                out.println("</html>");
            }
        } else {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos no esta autorizado a ingresar a esta pagina!!");
        }
    }

}
