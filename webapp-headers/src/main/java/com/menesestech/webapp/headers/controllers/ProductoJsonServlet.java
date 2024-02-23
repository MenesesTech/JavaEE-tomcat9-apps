package com.menesestech.webapp.headers.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.menesestech.webapp.headers.models.Producto;
import com.menesestech.webapp.headers.services.ProductoService;
import com.menesestech.webapp.headers.services.ProductoServiceImp;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ProductoJsonServlet", urlPatterns = {"/productos.json"})
public class ProductoJsonServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductoService service = new ProductoServiceImp();
        List<Producto> productos = service.listar();
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(productos);
        response.setContentType("application/json");
        response.getWriter().write(json);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletInputStream jsonStream = request.getInputStream();
        ObjectMapper mapper = new ObjectMapper();
        Producto producto = mapper.readValue(jsonStream, Producto.class);
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\">");
            out.println("<title>Detalle de producto desde json</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Detalle de producto desde json!</h1>");
            out.println("<ul>");
            out.println("<li>" + producto.getId() + "</li>");
            out.println("<li>" + producto.getNombre() + "</li>");
            out.println("<li>" + producto.getTipo() + "</li>");
            out.println("<li>" + producto.getPrecio() + "</li>");
            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}
