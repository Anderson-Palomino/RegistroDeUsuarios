<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Tabla de Usuarios</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>
    <body>
        <div class="container my-4" >
            <h2 class="mb-4">Tabla de Usuarios</h2>
            <div class="table-responsive">
                <table class="table table-bordered table-hover">
                    <thead class="table-dark">
                        <tr>
                            <th>Item AI</th>
                            <th>ID Usuario</th>
                            <th>Código Usuario</th>
                            <th>Usuario</th>
                            <th>Password</th>
                            <th>Nombres</th>
                            <th>Apellidos</th>
                            <th>Email</th>
                            <th>Permisos</th>
                            <th>Estado</th>
                            <th>En Línea</th>
                            <th>Número de Ingresos</th>
                            <th>Fecha Creación</th>
                            <th>Fecha Modificación</th>
                            <th>Fecha Eliminación</th>
                            <th>Fecha Último Acceso</th>
                            <th>Creado Por</th>
                            <th>Modificado Por</th>
                            <th>Eliminado Por</th>
                            <th>Hora Creación</th>
                            <th>Hora Modificación</th>
                            <th>Hora Eliminación</th>
                            <th>Hora Último Acceso</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="usuario" items="${listaUsuarios}">
                            <tr>
                                <td>${usuario.itemAi}</td>
                                <td>${usuario.idUsuario}</td>
                                <td>${usuario.codUsuario}</td>
                                <td>${usuario.usuario}</td>
                                <td>${usuario.password}</td>
                                <td>${usuario.nombres}</td>
                                <td>${usuario.apellidos}</td>
                                <td>${usuario.email}</td>
                                <td>${usuario.permisos}</td>
                                <td>${usuario.estado}</td>
                                <td>${usuario.enLinea}</td>
                                <td>${usuario.numIngresos}</td>
                                <td>${usuario.fecCreacion}</td>
                                <td>${usuario.fecModificacion}</td>
                                <td>${usuario.fecEliminacion}</td>
                                <td>${usuario.fecUltimoAcceso}</td>
                                <td>${usuario.creadoPor}</td>
                                <td>${usuario.modificadoPor}</td>
                                <td>${usuario.eliminadaPor}</td>
                                <td>${usuario.horaCreacion}</td>
                                <td>${usuario.horaModificacion}</td>
                                <td>${usuario.horaEliminacion}</td>
                                <td>${usuario.horaUltimoAcceso}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
