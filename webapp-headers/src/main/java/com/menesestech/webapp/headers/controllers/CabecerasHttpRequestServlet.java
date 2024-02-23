package com.menesestech.webapp.headers.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CabecerasHttpRequestServlet", urlPatterns = {"/cabeceras-request"})
public class CabecerasHttpRequestServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        //Metodo HTTP
        String metodoHTTP = request.getMethod();
        //Metodo Uniform Resource Identifier
        String requestUri = request.getRequestURI();
        //Url de la solicitud
        String requestUrl = request.getRequestURL().toString();
        //Contexto de la aplicacion en el servidor
        String contextPath = request.getContextPath();
        //Ruta del servlet que maneja la solicitud
        String servletPath = request.getServletPath();
        //Direccion Ip Local del servidor
        String ip = request.getLocalAddr();
        String ipCliente = request.getRemoteAddr();
        int port = request.getLocalPort();
        String scheme = request.getScheme();
        String host = request.getHeader("host");
        String url1 = scheme + "://"+ host + contextPath + servletPath;
        String url2 = scheme + "://" + ip + ":" + port +contextPath + servletPath;
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\">");
            out.println("<title>Cabecera Http Request</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Cabeceras HTTP Request</h1>");
            out.println("<ul class=\"list-group\">");
            out.println("<li class=\"list-group-item border-0\"><strong>Metodo http:</strong> " + metodoHTTP + "</li>");
            out.println("<li class=\"list-group-item border-0\"><strong>Metodo URI:</strong> " + requestUri + "</li>");
            out.println("<li class=\"list-group-item border-0\"><strong>Request Url:</strong> " + requestUrl + "</li>");
            out.println("<li class=\"list-group-item border-0\"><strong>ContextPath:</strong> " + contextPath + "</li>");
            out.println("<li class=\"list-group-item border-0\"><strong>Servlet path:</strong> " + servletPath + "</li>");
            out.println("<li class=\"list-group-item border-0\"><strong>Ip local:</strong> " + ip + "</li>");
            out.println("<li class=\"list-group-item border-0\"><strong>Ip cliente:</strong> " + ipCliente + "</li>");
            out.println("<li class=\"list-group-item border-0\"><strong>Puerto local:</strong> " + port + "</li>");
            out.println("<li class=\"list-group-item border-0\"><strong>Schema:</strong> " + scheme + "</li>");
            out.println("<li class=\"list-group-item border-0\"><strong>Host:</strong> " + host + "</li>");
            out.println("<li class=\"list-group-item border-0\"><strong>Url1:</strong> " + url1 + "</li>");
            out.println("<li class=\"list-group-item border-0\"><strong>Url2:</strong> " + url2 + "</li>");
            Enumeration<String> headerNames = request.getHeaderNames();
            while (headerNames.hasMoreElements()) {                
                String cabecera = headerNames.nextElement();
                out.println("<li class=\"list-group-item border-0\"><strong>"+cabecera+":</strong> "+request.getHeader(cabecera)+"</li>");
            }
            out.println("</ul>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
