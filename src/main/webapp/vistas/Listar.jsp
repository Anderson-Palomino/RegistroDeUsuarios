<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="conexion.Conexion"%>
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
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="vistas/home.jsp">Home</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                <img src="${pageContext.request.contextPath}/img/user2.png" height="40" width="40" class="rounded-circle" alt="User Image"> ${usuario}
                            </a>
                            <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="userDropdown">
                                <li><a class="dropdown-item">${sessionScope.email}</a></li>
                                <li><hr class="dropdown-divider"></li>
                                <li><a class="dropdown-item" href="LoginServlet?accion=Salir">Salir</a></li>
                            </ul>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <div class="container my-4">
            <h2 class="mb-4 text-center">Usuarios</h2>
            <div class="mb-3 text-end">
                <a href="PrincipalServlet?accion=add" class="btn btn-primary mb-2">Agregar nuevo usuario</a>
                <form action="PrincipalServlet" method="get" class="d-inline-block ms-3">
                    <div class="input-group">
                        <input type="hidden" name="accion" value="listar">
                        <input type="text" class="form-control" name="txtBuscar" placeholder="Buscar usuario">
                        <button type="submit" class="btn btn-outline-primary">Buscar</button>
                    </div>
                </form>
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
                            <th>Fecha Ultimo Acceso</th>
                            <th>Creado Por</th>
                            <th>Modificado Por</th>
                            <th>Eliminado Por</th>
                            <th>Hora Creación</th>
                            <th>Hora Modificación</th>
                            <th>Hora Ultimo Acceso</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            String codUsuario = request.getParameter("txtBuscar");
                            UsuarioDao dao = new UsuarioDao();
                            List<UsuarioDto> list;

                            if (codUsuario != null && !codUsuario.isEmpty()) {
                                list = dao.buscarPorNombre(codUsuario);  // Método para buscar por nombre
                            } else {
                                list = dao.listar();  // Si no hay búsqueda, lista todo
                            }

                            if (list == null || list.isEmpty()) {
                        %>
                        <tr>
                            <td colspan="22">No se encontraron resultados.</td>
                        </tr>
                        <%
                        } else {
                            Iterator<UsuarioDto> iter = list.iterator();
                            UsuarioDto usu = null;
                            while (iter.hasNext()) {
                                usu = iter.next();
                        %>
                        <tr>
                            <td><%= usu.getItemAi()%></td>
                            <td><%= usu.getIdUsuario()%></td>
                            <td><%= usu.getCodUsuario()%></td>
                            <td><%= usu.getUsuario()%></td>
                            <td><%= usu.getPassword()%></td>
                            <td><%= usu.getNombres()%></td>
                            <td><%= usu.getApellidos()%></td>
                            <td><%= usu.getEmail()%></td>
                            <td><%= usu.getPermisos()%></td>
                            <td><%= usu.getEstado()%></td>
                            <td><%= usu.isEnlinea()%></td>
                            <td><%= usu.getNumIngresos()%></td>
                            <td><%= usu.getFecCreacion()%></td>
                            <td><%= usu.getFecModificacion()%></td>
                            <td><%= usu.getFecEliminacion()%></td>
                            <td><%= usu.getFecUltimoAcceso()%></td>
                            <td><%= usu.getCreadoPor()%></td>
                            <td><%= usu.getModificadoPor()%></td>
                            <td><%= usu.getEliminadaPor()%></td>
                            <td><%= usu.getHoraCreacion()%></td>
                            <td><%= usu.getHoraEliminacion()%></td>
                            <td><%= usu.getHoraUltimoAcceso()%></td>
                            <td>
                                <a href="PrincipalServlet?accion=editar&idUsuario=<%= usu.getIdUsuario()%>" class="btn btn-warning btn-sm">Editar</a>
                                <a href="PrincipalServlet?accion=eliminar&idUsuario=<%= usu.getIdUsuario()%>" class="btn btn-danger btn-sm">Eliminar</a>
                            </td>
                        </tr>
                        <%  }
                            }%>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
