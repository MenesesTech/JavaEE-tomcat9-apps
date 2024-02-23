package com.menesestech.webapp.headers.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "HoraActualizadaServlet", urlPatterns = {"/hora-actualizada"})
public class HoraActualizadaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("refresh", "1");
        LocalTime hora = LocalTime.now();
        DateTimeFormatter df = DateTimeFormatter.ofPattern("hh:mm:ss");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>La hora actualizada</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>La hora actualizada</h1>");
            out.println("<h3>"+hora.format(df)+"</h3>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
