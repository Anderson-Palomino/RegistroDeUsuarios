<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">

    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Registro de usuarios</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
              crossorigin="anonymous">
        <link href="${pageContext.request.contextPath}/css/addYedit.css" rel="stylesheet" type="text/css"/>
        <!-- Cargar FontAwesome -->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" crossorigin="anonymous">
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
                <div class="col-md-6">
                    <h2 class="text-center mb-4"><i class="fas fa-user-plus"></i> Agregar usuarios</h2>
                    <form action="PrincipalServlet">
                        <div class="mb-3">
                            <label for="usuario" class="form-label"><i class="fas fa-user"></i> Usuario</label>
                            <input type="text" class="form-control" id="usuario" name="usuario" required>
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label"><i class="fas fa-lock"></i> Contraseña</label>
                            <input type="password" class="form-control" id="password" name="password" required>
                        </div>
                        <div class="mb-3">
                            <label for="nombres" class="form-label"><i class="fas fa-id-card"></i> Nombres</label>
                            <input type="text" class="form-control" id="nombres" name="nombres" required>
                        </div>
                        <div class="mb-3">
                            <label for="apellidos" class="form-label"><i class="fas fa-id-card-alt"></i> Apellidos</label>
                            <input type="text" class="form-control" id="apellidos" name="apellidos" required>
                        </div>
                        <div class="mb-3">
                            <label for="email" class="form-label"><i class="fas fa-envelope"></i> Email</label>
                            <input type="email" class="form-control" id="email" name="email" required>
                        </div>

                        <div class="mb-3">
                            <label for="permisos" class="form-label"><i class="fas fa-user-shield"></i> Permisos</label>
                            <select class="form-select" id="permisos" name="permisos" required>
                                <c:choose>
                                    <c:when test="${sessionScope.codUsuario eq 'ADM1'}">
                                        <option value="UsuarioNormal">Usuario Normal</option>
                                        <option value="Administrador">Administrador</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option value="UsuarioNormal">Usuario Normal</option>
                                    </c:otherwise>
                                </c:choose>
                            </select>
                        </div>

                        <div class="d-grid gap-2">
                            <input type="submit" class="btn btn-primary" name="accion" value="Agregar">
                        </div>
                    </form>
                </div>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
    </body>

</html>
