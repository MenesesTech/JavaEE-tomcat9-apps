package com.menesestech.webapp.formulario.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "registroform", urlPatterns = {"/registroform"})
public class FormServlets extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String pais = request.getParameter("pais");
        String[] lenguajes = request.getParameterValues("lenguajes");
        String[] roles = request.getParameterValues("roles");
        String idioma = request.getParameter("idiomas");
        String habilitar = request.getParameter("habilitar");
        String secreto = request.getParameter("secreto");
        List<String> errores = new ArrayList<>();
        if (username == null || username.isBlank()) {
            errores.add("El username es requerido");
        }
        if (password == null || password.isBlank()) {
            errores.add("El password es requerido");
        }
        if (email == null || !email.matches(".+@.+\\..+")) {
            errores.add("El email es requerido o tiene un formato incorrecto");
        }
        if (pais == null || pais.trim().isEmpty()) {
            errores.add("El país es requerido");
        }
        if (lenguajes == null || lenguajes.length == 0) {
            errores.add("Debe seleccionar al menos un tema");
        }
        if (roles == null || roles.length == 0) {
            errores.add("Debe seleccionar al menos un rol");
        }
        if (idioma == null) {
            errores.add("Debe seleccionar al menos un idioma");
        }
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use the following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvUsuarios</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Respuesta de formulario</h1>");
            out.println("<ul>");
            if (errores.isEmpty()) {

                out.println("<li>Username: " + username + "</li>");
                out.println("<li>Password: " + password + "</li>");
                out.println("<li>Email: " + email + "</li>");
                out.println("<li>País: " + pais + "</li>");
                out.println("<li>Lenguajes: <ul>");
                if (lenguajes != null) {
                    for (String lenguaje : lenguajes) {
                        out.println("<li>" + lenguaje + "</li>");
                    }
                }
                out.println("</ul></li>");
                out.println("<li>Roles: <ul>");
                if (roles != null) {
                    for (String role : roles) {
                        out.println("<li>" + role + "</li>");
                    }
                }
                out.println("</ul></li>");
                out.println("<li>Idioma: " + idioma + "</li>");
                out.println("<li>Habilitar: " + habilitar + "</li>");
                out.println("<li>Secreto: " + secreto + "</li>");
            } else {
//                errores.forEach(error -> {
//                    out.println("<li>" + error + "</li>");
//                });
//                out.println("<p><a href=\"/webapp-formulario/index.html\">Volver al formulario</a></p>");
                request.setAttribute("errores", errores);
                getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }
            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
