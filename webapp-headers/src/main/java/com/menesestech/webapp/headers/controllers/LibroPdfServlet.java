package com.menesestech.webapp.headers.controllers;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.menesestech.webapp.headers.models.Libro;
import com.menesestech.webapp.headers.services.LibroService;
import com.menesestech.webapp.headers.services.LibroServiceImp;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LibroPdfServlet", urlPatterns = {"/libros.pdf", "/libros", "/libros.html"})
public class LibroPdfServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        LibroService servicePdf = new LibroServiceImp();
        List<Libro> libros = servicePdf.listar();
        String servletPath = request.getServletPath();
        boolean esPdf = servletPath.endsWith(".pdf");
        if (esPdf) {
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "inline; filename=libros.pdf");
            Document document = new Document();
            try {
                PdfWriter.getInstance(document, response.getOutputStream());

                document.open();
                document.add(new Paragraph("Listado de libros"));
                PdfPTable table = new PdfPTable(4);
                table.addCell("id");
                table.addCell("Titulo");
                table.addCell("Autor");
                table.addCell("Genero");
                for (Libro libro : libros) {
                    table.addCell(libro.getId().toString());
                    table.addCell(libro.getTitulo());
                    table.addCell(libro.getAutor());
                    table.addCell(libro.getGenero());
                }

                document.add(table);
            } catch (DocumentException e) {
                e.printStackTrace();
            } finally {
                document.close();
            }

        }

        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\">");
            out.println("<title>Servlet LibroPdfServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Listado de Libros</h1>");
            out.println("<table class=\"table\">");
            out.println("<caption>Lista de libros</caption>");
            out.println("<thead>");
            out.println("<tr>");
            out.println("<th scope=\"col\">id</th>");
            out.println("<th scope=\"col\">Titulo</th>");
            out.println("<th scope=\"col\">Autor</th>");
            out.println("<th scope=\"col\">Genero</th>");
            out.println("</tr>");
            out.println("</thead>");
            out.println("<tbody>");
            libros.forEach(lib -> {
                out.println("<tr>");
                out.println("<th scope=\"row\">" + lib.getId() + "</th>");
                out.println("<td>" + lib.getTitulo() + "</td>");
                out.println("<td>" + lib.getAutor() + "</td>");
                out.println("<td>" + lib.getGenero() + "</td>");
                out.println("</tr>");
            });
            out.println("</tbody>");
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
