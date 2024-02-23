
package com.menesestech.webapp.headers.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "RedirigirServlet", urlPatterns = {"/redirigir"})
public class RedirigirServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setHeader("Location", request.getContextPath()+"/productos.html");
//        response.setStatus(HttpServletResponse.SC_FOUND);
          response.sendRedirect(request.getContextPath()+"/productos.html");
    }
}
