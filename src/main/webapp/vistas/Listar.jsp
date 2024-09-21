<%@page import="java.util.Iterator"%> 
<%@page import="java.util.List"%>
<%@page import="Modelo.UsuarioDto"%>
<%@page import="Modelo.UsuarioDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Tabla de Usuarios</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/listar.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container my-4">
            <h2 class="mb-4 text-center">Usuarios</h2>
            <div class="mb-3 text-end">
                <a href="PrincipalServlet?accion=add" class="btn btn-primary">Agregar nuevo usuario</a>
            </div>
            <div class="table-responsive">
                <table class="table table-bordered table-hover">
                    <thead>
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
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% 
                            UsuarioDao dao = new UsuarioDao();
                            List<UsuarioDto> list = dao.listar();
                            Iterator<UsuarioDto> iter = list.iterator();
                            UsuarioDto usu = null;
                            while (iter.hasNext()) {
                                usu = iter.next(); 
                        %>
                        <tr>
                            <td><%= usu.getItemAi() %></td>
                            <td><%= usu.getIdUsuario() %></td>
                            <td><%= usu.getCodUsuario() %></td>
                            <td><%= usu.getUsuario() %></td>
                            <td><%= usu.getPassword() %></td>
                            <td><%= usu.getNombres() %></td>
                            <td><%= usu.getApellidos() %></td>
                            <td><%= usu.getEmail() %></td>
                            <td><%= usu.getPermisos() %></td>
                            <td><%= usu.getEstado() %></td>
                            <td><%= usu.isEnlinea() %></td>
                            <td><%= usu.getNumIngresos() %></td>
                            <td><%= usu.getFecCreacion() %></td>
                            <td><%= usu.getFecModificacion() %></td>
                            <td><%= usu.getFecEliminacion() %></td>
                            <td><%= usu.getFecUltimoAcceso() %></td>
                            <td><%= usu.getCreadoPor() %></td>
                            <td><%= usu.getModificadoPor() %></td>
                            <td><%= usu.getEliminadaPor() %></td>
                            <td><%= usu.getHoraCreacion() %></td>
                            <td><%= usu.getHoraModificacion() %></td>
                            <td><%= usu.getHoraEliminacion() %></td>
                            <td><%= usu.getHoraUltimoAcceso() %></td>
                            <td>
                                <a href="PrincipalServlet?accion=editar&idUsuario=<%= usu.getIdUsuario() %>" class="btn btn-warning btn-sm">Editar</a>
                                <a href="PrincipalServlet?accion=eliminar&idUsuario=<%= usu.getIdUsuario() %>" class="btn btn-danger btn-sm">Eliminar</a>
                            </td>
                        </tr>
                        <% }%>
                    </tbody>
                </table>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
