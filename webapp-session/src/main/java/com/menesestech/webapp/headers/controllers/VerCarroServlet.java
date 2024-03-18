package com.menesestech.webapp.headers.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "VerCarroServlet", urlPatterns = {"/ver-carro"})
public class VerCarroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Redireccionar la solicitud a carro.jsp para visualizar el carro
        getServletContext().getRequestDispatcher("/carro.jsp").forward(request, response);
    }
}
