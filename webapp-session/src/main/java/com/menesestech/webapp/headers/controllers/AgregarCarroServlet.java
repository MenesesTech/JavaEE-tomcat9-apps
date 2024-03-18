package com.menesestech.webapp.headers.controllers;

import com.menesestech.webapp.headers.models.Carro;
import com.menesestech.webapp.headers.models.ItemCarro;
import com.menesestech.webapp.headers.models.Producto;
import com.menesestech.webapp.headers.services.ProductoService;
import com.menesestech.webapp.headers.services.ProductoServiceImp;
import java.io.IOException;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "AgregarCarroServlet", urlPatterns = {"/agregar-carro"})
public class AgregarCarroServlet extends HttpServlet {

    @Override
    // Método para manejar las solicitudes GET
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //Obtener el ID del producto de la solicitud
        Long id = Long.parseLong(request.getParameter("id"));
        //Crear una instancia del servicio de producto
        ProductoService service = new ProductoServiceImp();
        //Obtener el producto por su ID
        Optional<Producto> producto = service.porId(id);
        //Si el producto está presente
        if (producto.isPresent()) {
            // Crear un elemento de carro con cantidad 1 y el producto
            ItemCarro item = new ItemCarro(1, producto.get());
            // Obtener la sesión HTTP
            HttpSession session = request.getSession();
            Carro carro;
            // Si no hay un carro en la sesión, crear uno y establecerlo en la sesión
            if (session.getAttribute("carro") == null) {
                carro = new Carro();
                session.setAttribute("carro", carro);
            } else {
                // Si ya hay un carro en la sesión, obtenerlo
                carro = (Carro) session.getAttribute("carro");
            }
            // Agregar el elemento de carro al carro
            carro.addItemCarro(item);
        }
        // Redirigir a la página para ver el carro
        response.sendRedirect(request.getContextPath() + "/ver-carro");
    }
}
