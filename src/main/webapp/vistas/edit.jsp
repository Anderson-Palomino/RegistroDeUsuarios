<%@page import="Modelo.UsuarioDto" %>
<%@page import="Modelo.UsuarioDao" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Modificar usuario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
          crossorigin="anonymous">
    <link href="${pageContext.request.contextPath}/css/addYedit.css" rel="stylesheet" type="text/css"/>
    <!-- Nueva URL de FontAwesome sin el atributo 'integrity' -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
          crossorigin="anonymous">
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

<div class="container mt-5">
    <div class="row justify-content-center">
        <%
            UsuarioDao dao = new UsuarioDao();
            int idUsuario = Integer.parseInt((String) request.getAttribute("idusu"));
            UsuarioDto u = (UsuarioDto) dao.list(idUsuario);
        %>
        <div class="col-md-6">
            <h2 class="text-center mb-4"><i class="fas fa-user-edit"></i> Modificar usuario</h2>
            <form action="PrincipalServlet">
                <div class="mb-3">
                    <label for="usuario" class="form-label"><i class="fas fa-user"></i> Usuario</label>
                    <input type="text" class="form-control" id="usuario" name="usuario" value="<%= u.getUsuario()%>"
                           required>
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label"><i class="fas fa-lock"></i> Contraseña</label>
                    <input type="password" class="form-control" id="password" name="password"
                           value="<%= u.getPassword()%>" required>
                </div>
                <div class="mb-3">
                    <label for="nombres" class="form-label"><i class="fas fa-id-badge"></i> Nombres</label>
                    <input type="text" class="form-control" id="nombres" name="nombres" value="<%= u.getNombres()%>"
                           required>
                </div>
                <div class="mb-3">
                    <label for="apellidos" class="form-label"><i class="fas fa-id-badge"></i> Apellidos</label>
                    <input type="text" class="form-control" id="apellidos" name="apellidos"
                           value="<%= u.getApellidos()%>" required>
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label"><i class="fas fa-envelope"></i> Email</label>
                    <input type="email" class="form-control" id="email" name="email" value="<%= u.getEmail()%>"
                           required>
                </div>
                <div class="mb-3">
                    <label for="permisos" class="form-label"><i class="fas fa-user-shield"></i> Permisos</label>
                    <c:choose>
                        <c:when test="${sessionScope.codUsuario == 'ADM1'}">
                            <select class="form-select" id="permisos" name="permisos" required>
                                <option value="UsuarioNormal"
                                        <c:if test="${u.getPermisos() == 'UsuarioNormal'}">selected</c:if>>Usuario
                                    Normal
                                </option>
                                <option value="Administrador"
                                        <c:if test="${u.getPermisos() == 'Administrador'}">selected</c:if>>Administrador
                                </option>
                            </select>
                        </c:when>
                        <c:otherwise>
                            <input type="hidden" id="permisos" name="permisos" value="<%= u.getPermisos()%>">
                        </c:otherwise>
                    </c:choose>
                </div>
                <div class="mb-3">
                    <label for="estado" class="form-label"><i class="fas fa-user-check"></i> Estado</label>
                    <select class="form-select" id="estado" name="estado" required>
                        <option value="1" <c:if test="${u.getEstado() == 1}">selected</c:if>>Activo</option>
                        <option value="2" <c:if test="${u.getEstado() == 2}">selected</c:if>>Suspendido</option>
                        <option value="0" <c:if test="${u.getEstado() == 0}">selected</c:if>>Eliminado</option>
                    </select>

                </div>
                <input type="hidden" name="idUsuario" value="<%= u.getIdUsuario()%>">
                <div class="d-grid gap-2">
                    <input type="submit" class="btn btn-primary" name="accion" value="Actualizar">
                    <a href="PrincipalServlet?accion=listar" class="btn btn-secondary"><i class="fas fa-arrow-left"></i>
                        Regresar</a>
                </div>
            </form>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        crossorigin="anonymous"></script>
</body>
</html>
