package com.menesestech.webapp.headers.controllers;

import com.menesestech.webapp.headers.models.Producto;
import com.menesestech.webapp.headers.services.ProductoService;
import com.menesestech.webapp.headers.services.ProductoServiceImp;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "productos.xls", urlPatterns = {"/productos.xls", "/productos", "/productos.html"})
public class ProductoXlsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        ProductoService service = new ProductoServiceImp();
        List<Producto> productos = service.listar();
        String servletPath = request.getServletPath();
        boolean esXls = servletPath.endsWith(".xls");
        if (esXls) {
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename=productos.xls");
        }
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\">");
            out.println("<title>Listado de productos</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Listado de productos</h1>");
            out.println("<p><a href=\"" + request.getContextPath() + "/productos.json" + "\">Mostrar JSON</a></p>");
            out.println("<table class=\"table\">");
            out.println("<caption>Lista de Productos</caption>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th scope=\"col\">id</th>");
            out.println("<th scope=\"col\">Nombre</th>");
            out.println("<th scope=\"col\">Tipo</th>");
            out.println("<th scope=\"col\">Precio</th>");
            out.println("</tr>");
            out.println("</thead>");
            productos.forEach(p -> {
                out.println("<tr>");
                out.println("<th scope=\"row\">" + p.getId() + "</th>");
                out.println("<td>" + p.getNombre() + "</td>");
                out.println("<td>" + p.getTipo() + "</td>");
                out.println("<td>" + p.getPrecio() + "</td>");
                out.println("</tr>");
            });
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
