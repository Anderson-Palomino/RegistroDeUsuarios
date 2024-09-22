<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/styles.css">
        <title>Login de usuarios</title>
    </head>
    <body>
        <div class="container d-flex align-items-center justify-content-center vh-100">
            <div class="card shadow" style="width: 400px;">
                <div class="card-body">
                    <div class="text-center mb-4">
                        <img src="${pageContext.request.contextPath}/img/user1.png" class="img-fluid" width="80" alt="User Icon"/>
                        <h5 class="mt-2"><strong>Bienvenidos al sistema</strong></h5>
                    </div>
                    <form action="${pageContext.request.contextPath}/LoginServlet" method="POST">
                        <div class="mb-3">
                            <label for="usuario" class="form-label">Usuario:</label>
                            <input type="text" name="txtUsuario" class="form-control" id="usuario" placeholder="Ingrese su usuario">
                        </div>
                        <div class="mb-3">
                            <label for="contraseña" class="form-label">Contraseña:</label>
                            <input type="password" name="txtPassword" class="form-control" id="password" placeholder="Ingrese su contraseña">
                        </div>
                        <input type="submit" name="accion" class="btn btn-primary w-100" value="Ingresar">
                    </form>

                </div>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
