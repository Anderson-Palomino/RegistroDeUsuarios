<%@page import="java.lang.String"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="conexion.Conexion"%>
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
        <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/css/listar.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <c:choose>
            <c:when test="${sessionScope.permisos eq 'Administrador'}">
                <%@ include file="navbarAdministrador.jsp" %>
            </c:when>
            <c:otherwise>
                <%@ include file="navbarUsuarioNormal.jsp" %>
            </c:otherwise>
        </c:choose>
        <div class="container my-4">
            <h2 class="mb-4 text-center">Usuarios</h2>
            <div class="mb-3 text-end">
                <a href="PrincipalServlet?accion=add" class="btn btn-primary mb-2">
                    <i class="fa-solid fa-user-plus"></i> Agregar nuevo usuario
                </a>
                <form action="PrincipalServlet" method="get" class="d-inline-block ms-3">
                    <div class="input-group">
                        <input type="hidden" name="accion" value="listar">
                        <input type="text" class="form-control" name="txtBuscar" placeholder="Buscar usuario">
                        <button type="submit" class="btn btn-outline-primary">
                            <i class="fa-solid fa-search"></i> Buscar
                        </button>
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
                            <th>Fecha Último Acceso</th>
                            <th>Creado Por</th>
                            <th>Modificado Por</th>
                            <th>Eliminado Por</th>
                            <th>Hora Creación</th>
                            <th>Hora Modificación</th>
                            <th>Hora Eliminacion</th>
                            <th>Hora Último Acceso</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            String codUsuario = (String) session.getAttribute("codUsuario");
                            String txtBuscar = request.getParameter("txtBuscar"); // Obtener el valor de búsqueda
                            UsuarioDao dao = new UsuarioDao();
                            List<UsuarioDto> list;

                            if (txtBuscar != null && !txtBuscar.isEmpty()) {
                                // Verifica si el usuario en sesión es ADM1
                                if ("ADM1".equals(codUsuario)) {
                                    // ADM1 puede buscar cualquier usuario
                                    list = dao.buscarPorCodUsuario(txtBuscar, codUsuario); // Método para buscar usuario por código
                                } else {
                                    // Otros administradores solo pueden buscar usuarios normales
                                    list = dao.buscarPorCodUsuario(txtBuscar, codUsuario);
                                }
                            } else {
                                // Si no hay búsqueda, seguir listando según el usuario logueado
                                list = dao.listar(codUsuario);
                            }

                            if (list == null || list.isEmpty()) {
                        %>
                        <tr>
                            <td colspan="22">No se encontraron resultados.</td>
                        </tr>
                        <%
                        } else {
                            for (UsuarioDto usu : list) {
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
                            <td><%= usu.getEstadoTexto()%></td>
                            <td>
                                <%
                                    if ("Online".equals(usu.getEnLineaTexto())) {
                                %>
                                <i class="fa-solid fa-circle" style="color: green;"></i> <%= usu.getEnLineaTexto()%>
                                <%
                                } else {
                                %>
                                <i class="fa-solid fa-circle" style="color: red;"></i> <%= usu.getEnLineaTexto()%>
                                <%
                                    }
                                %>
                            </td>

                            <td><%= usu.getNumIngresos()%></td>
                            <td><%= usu.getFecCreacion()%></td>
                            <td><%= usu.getFecModificacionTexto()%></td>
                            <td><%= usu.getFecEliminacionTexto()%></td>
                            <td><%= usu.getFecUltimoAccesoTexto()%></td>
                            <td><%= usu.getCreadoPor()%></td>
                            <td><%= usu.getModificadoPorTexto()%></td>
                            <td><%= usu.getEliminadaPorTexto()%></td>
                            <td><%= usu.getHoraCreacion()%></td>
                            <td><%= usu.getHoraModificacionTexto()%></td>
                            <td><%= usu.getHoraEliminacionTexto()%></td>
                            <td><%= usu.getHoraUltimoAccesoTexto()%></td>
                            <td>
                                <a href="PrincipalServlet?accion=editar&idUsuario=<%= usu.getIdUsuario()%>" class="btn btn-warning btn-sm">
                                    <i class="fa-solid fa-pen"></i> Editar
                                </a>
                                <a href="PrincipalServlet?accion=eliminar&idUsuario=<%= usu.getIdUsuario()%>" class="btn btn-danger btn-sm">
                                    <i class="fa-solid fa-trash"></i> Eliminar
                                </a>
                            </td>
                        </tr>

                        <%
                                }
                            }
                        %>
                    </tbody>
                </table>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>
