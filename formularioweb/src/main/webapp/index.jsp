<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>

<%
    List<String> errores = (List<String>) request.getAttribute("errores");
%>

<!DOCTYPE html>
<html>
    <head>
        <title>Start Page</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    </head>
    <body>

        <h3>Formulario de usuarios</h3>
        <%
            if (errores != null && errores.size() > 0) {
        %>
        <ul class="alert alert-danger">
            <% for (String error : errores) {%>
            <li><%= error%></li>
                <% } %>
        </ul>
        <%
            }
        %>
        <div class="px-5">
            <form action="registroform" method="POST">
                <div class="row mb-3">
                    <label for="username" class="col-form-label col-sm-2">Usuario</label>
                    <div class="col-sm-4"><input type="text" name="username" id="username" class="form-control"></div>
                </div>
                <div class="row mb-3">
                    <label for="password" class="col-form-label col-sm-2">Password</label>
                    <div class="col-sm-4"><input type="password" name="password" id="password" class="form-control"></div>
                </div>
                <div class="row mb-3">
                    <label for="email" class="col-form-label col-sm-2">Email</label>
                    <div class="col-sm-4"><input type="text" name="email" id="email" class="form-control"></div>
                </div>
                <div class="row mb-3">
                    <label for="pais" class="col-form-label col-sm-2">Paí­s</label>
                    <div class="col-sm-4">
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
                <div class="row mb-3">
                    <label for="lenguajes" class="col-form-label col-sm-2">Lenguajes de programación</label>
                    <div class="col-sm-4">
                        <select name="lenguajes" id="lenguajes" multiple class="form-select">
                            <option value="java" selected>JAVA SE</option>
                            <option value="jakartaee">Jakarta EE9</option>
                            <option value="spring">Spring Boot</option>
                            <option value="js">JavaScript</option>
                            <option value="angular" selected>Angular</option>
                            <option value="react">React</option>
                        </select>
                    </div>
                </div>

                <div class="row mb-3">
                    <label for="roles" class="col-form-label col-sm-2">Roles</label>
                    <div class="form-check col-sm-2">
                        <input type="checkbox" name="roles" value="ROLE_ADMIN">
                        <label class="form-check-label">Administrador</label>
                    </div>
                    <div class="form-check col-sm-2">
                        <input type="checkbox" name="roles" value="ROLE_USER" checked>
                        <label class="form-check-label">Usuario</label>
                    </div>
                    <div class="form-check col-sm-2">
                        <input type="checkbox" name="roles" value="ROLE_MODERATOR">
                        <label class="form-check-label">Moderador</label>
                    </div>
                </div>
                <div class="row mb-3">
                    <label class="col-form-label col-sm-2">Idiomas</label>
                    <div class="form-check col-sm-2">
                        <input type="radio" name="idiomas" value="es" class="form-check-input">
                        <label class="form-check-label">Español</label>
                    </div>
                    <div class="form-check col-sm-2">
                        <input type="radio" name="idiomas" value="en" class="form-check-input">
                        <label class="form-check-label">Ingles</label>
                    </div>
                    <div class="form-check col-sm-2">
                        <input type="radio" name="idiomas" value="fr" class="form-check-input">
                        <label class="form-check-label">Frances</label>
                    </div>
                </div>
                <div class="row mb-3">
                    <label for="habilitar" class="col-form-label col-sm-2">Habilitar</label>
                    <div class="form-check col-sm-2">
                        <input type="checkbox" name="habilitar" id="habilitar" class="form-check-input">
                    </div>
                </div>
                <div class="row mb-3">
                    <div>
                        <button type="submit" class="btn btn-primary">Enviar</button>
                    </div>
                </div>
                <input type="hidden" name="secreto" value="12345">
            </form>
        </div>
    </body>
</html>
