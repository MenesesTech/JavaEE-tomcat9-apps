<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Map"%>
<%
    Map<String, String> errores = (Map<String, String>) request.getAttribute("errores");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Formulario con Java</title>
        <link rel="stylesheet" type="text/css" href="assets/styles.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container md">
            <div class="h3-center-text"><h3>Formulario de usuarios</h3></div>
            <form action="FormServlets" method="post" class="container-form col-sm-4 mx-auto">
                <div class="row mb-3">
                    <label for="username" class="col-form-label col-sm-2">Usuario</label>
                    <div><input type="text" name="username" id="username" class="form-control" placeholder="Ingrese nombre de usuario"></div>
                </div>
                <%
                    if (errores != null && errores.containsKey("username")) {
                        out.println("<div style='color: red;'>" + errores.get("username") + "</div>");
                    }
                %>
                <div class="row mb-3">
                    <label for="password" class="col-form-label col-sm-2">Password</label>
                    <div><input type="password" name="password" id="password" class="form-control" placeholder="Introduzca la contraseña de su correo electronico" aria-label="Password"></div>
                </div>
                <%
                    if (errores != null && errores.containsKey("password")) {
                        out.println("<small style='color: red;'>" + errores.get("password") + "</small>");
                    }
                %>
                <div class="row mb-3">
                    <label for="email" class="col-form-label col-sm-2">Email</label>
                    <div><input type="text" name="email" id="email" class="form-control" placeholder="Introduzca su direccion de correo electronico" aria-label="Email"></div>
                </div>
                <%
                    if (errores != null && errores.containsKey("email")) {
                        out.println("<small style='color: red;'>" + errores.get("email") + "</small>");
                    }
                %>
                <div class="row mb-3">
                    <label for="pais" class="col-form-label">País</label>
                    <div>
                        <select name="pais" id="pais" class="form-select">
                            <option value="">--seleccionar--</option>
                            <option value="ES">España</option>
                            <option value="MX">Mexico</option>
                            <option value="CL">Chile</option>
                            <option value="AR">Argentina</option>
                            <option value="PE">Perú</option>
                            <option value="CO">Colombia</option>
                            <option value="VE">Venezuela</option>
                        </select>
                    </div>
                </div>
                <%
                    if (errores != null && errores.containsKey("pais")) {
                        out.println("<small style='color: red;'>" + errores.get("pais") + "</small>");
                    }
                %>
                <div class="row mb-3">
                    <label for="lenguaje" class="col-form-label">Lenguaje de programacion favorito</label>
                    <div>
                        <select name="lenguaje" id="lenguaje" class="form-select">
                            <option value="java" selected>JAVA SE</option>
                            <option value="jakartaee">Jakarta EE9</option>
                            <option value="spring">Spring Boot</option>
                            <option value="js">JavaScript</option>
                            <option value="angular" selected>Angular</option>
                            <option value="react">React</option>
                        </select>
                    </div>
                </div>
                <%
                    if (errores != null && errores.containsKey("lenguajes")) {
                        out.println("<small style='color: red;'>" + errores.get("lenguajes") + "</small>");
                    }
                %>
                <div class="row mb-3">
                    <div class="d-grid gap-2 col-6 mx-auto"><button type="submit" class="btn btn-primary btn-lg">Enviar</button></div>
                </div>
            </form>
        </div>
    </body>
</html>