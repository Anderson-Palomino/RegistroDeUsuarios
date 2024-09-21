<%@page import="Modelo.UsuarioDto"%>
<%@page import="Modelo.UsuarioDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Modificar usuario</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    </head>

    <body>
        <div class="container mt-5">
            <div class="row justify-content-center">
                <%
                    UsuarioDao dao = new UsuarioDao();
                    int idUsuario = Integer.parseInt((String) request.getAttribute("idusu"));
                    UsuarioDto u = (UsuarioDto) dao.list(idUsuario);
                %>
                <div class="col-md-6">
                    <h2 class="text-center mb-4">Modificar usuario</h2>
                    <form action="PrincipalServlet">
                        <div class="mb-3">
                            <label for="usuario" class="form-label">Usuario</label>
                            <input type="text" class="form-control" id="usuario" name="usuario" value="<%= u.getUsuario()%>">
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Contraseña</label>
                            <input type="password" class="form-control" id="password" name="password" value="<%= u.getPassword()%>" required>
                        </div>
                        <div class="mb-3">
                            <label for="nombres" class="form-label">Nombres</label>
                            <input type="text" class="form-control" id="nombres" name="nombres" value="<%= u.getNombres()%>" required>
                        </div>
                        <div class="mb-3">
                            <label for="apellidos" class="form-label">Apellidos</label>
                            <input type="text" class="form-control" id="apellidos" name="apellidos" value="<%= u.getApellidos()%>" required>
                        </div>
                        <div class="mb-3">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" class="form-control" id="email" name="email" value="<%= u.getEmail()%>" required>
                        </div>
                        <div class="mb-3">
                            <label for="permisos" class="form-label">Permisos</label>
                            <select class="form-select" id="permisos" name="permisos" value="<%= u.getPermisos()%>">
                                <option value="usuarioNormal">Usuario Normal</option>
                                <option value="administrador">Administrador</option>
                            </select>
                        </div>
                        <input type="hidden" name="idUsuario" value="<%= u.getIdUsuario()%>">
                        <div class="d-grid gap-2">
                            <input type="submit" class="btn btn-primary" name="accion" value="Actualizar">
                            <a href="PrincipalServlet?accion=listar" class="btn btn-secondary">Regresar</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
                integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous">
        </script>
    </body>

</html>
