<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <title>Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div style="background-color: black; width: 300px; height: 300px; margin-left: auto; margin-right: auto">
            <h3 style="display: flex; margin-bottom: 50px; padding-top:20px; justify-content: center">Iniciar sesion</h3>

            <div class="container" style="width: 300px;">
                <form action="/webapp-cookie/login" method="post">
                    <div class="form-floating mb-3">
                        <input type="email" class="form-control" id="floatingInput" placeholder="name@example.com" name="username">
                        <label for="username">Username</label>
                    </div>  
                    <div class="form-floating">
                        <input type="password" class="form-control" id="floatingPassword" placeholder="Password" name="password">
                        <label for="floatingPassword">Password</label>
                    </div>
                    <button type="submit" class="btn btn-primary" value="Login">Inicar Sesion</button>
                </form>

            </div> 
        </div>

    </body>
</html>
