package com.menesestech.web.headers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FormServlets", urlPatterns = {"/FormServlets"})
public class FormServlets extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Configuracion del tipo de contenido para la respuesta
        response.setContentType("text/html;charset=UTF-8");
        
        //Obtencion de parametros del formulario
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String pais = request.getParameter("pais");
        String lenguaje = request.getParameter("lenguaje");
        
        //Mapa para almacenar mensajes de error asociados con campos especificos
        Map<String, String> errores = new HashMap<>();
        
        //Validaciones de los campos del formulario
        if (username == null || username.isBlank()) {
            errores.put("username", "el username no puede ser vacio!");
        }

        if (password == null || password.isBlank()) {
            errores.put("password", "el password es requerido!");
        }

        if (email == null || !email.contains("@")) {
            errores.put("email", "el email es requerido y debe tener un formato de correo.");
        }
        if (pais == null || pais.equals("") || pais.equals(" ")) {
            errores.put("pais", "el pais es requerido!");
        }
        if (lenguaje == null || lenguaje.equals("") || lenguaje.equals(" ")) {
            errores.put("lenguajes", "debe seleccionar al menos un tema.");
        }
        
        //Si no hay errores, se genera la respuesta HTML
        if (errores.isEmpty()) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html lang=\"es\">");
                out.println("<head>");
                out.println("<meta charset=\"UTF-8\">");
                out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
                out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\">");
                out.println("<title>Respuesta del Formulario</title>");
                out.println("</head>");
                out.println("<body class=\"bg-light\">");
                out.println("<div class=\"container mt-5\">");
                out.println("<h1 class=\"display-4 text-center mb-4\">Respuesta del formulario</h1>");
                out.println("<ul class=\"list-group\">");
                out.println("<li class=\"list-group-item border-0\"><strong>Username:</strong> " + username + "</li>");
                out.println("<li class=\"list-group-item border-0\"><strong>Password:</strong> " + password + "</li>");
                out.println("<li class=\"list-group-item border-0\"><strong>Email:</strong> " + email + "</li>");
                out.println("<li class=\"list-group-item border-0\"><strong>País:</strong> " + pais + "</li>");
                out.println("<li class=\"list-group-item border-0\"><strong>Lenguaje:</strong> " + lenguaje + "</li>");
                out.println("<li class=\"list-group-item border-0\"><a href=\"/web-headers\">Volver al formulario</a></li>");
                out.println("</ul>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            }
        }else{
            //Si hay errores, redirigir al formulario junto con los errores
            request.setAttribute("errores", errores);
            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }

    }

}
