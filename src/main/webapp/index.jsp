<%@page contentType="text/html" pageEncoding="UTF-8"%><!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tabla de Usuarios</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container my-4">
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
                    <!-- Aquí van las filas de la tabla -->
                    <tr>
                        <td>1</td>
                        <td>1001</td>
                        <td>USR001</td>
                        <td>admin1</td>
                        <td>adminpass</td>
                        <td>Juan</td>
                        <td>Perez</td>
                        <td>admin1@empresa.com</td>
                        <td>Administrador</td>
                        <td>1</td>
                        <td>1</td>
                        <td>10</td>
                        <td>2023-09-28</td>
                        <td>2023-09-29</td>
                        <td>2023-11-01</td>
                        <td>2023-11-01</td>
                        <td>admin1</td>
                        <td>admin1</td>
                        <td>admin7</td>
                        <td>09:00:00</td>
                        <td>10:00:00</td>
                        <td>10:30:00</td>
                        <td>12:00:00</td>
                    </tr>
                    <tr>
                        <td>2</td>
                        <td>1002</td>
                        <td>USR002</td>
                        <td>user1</td>
                        <td>userpass</td>
                        <td>Maria</td>
                        <td>Garcia</td>
                        <td>user1@empresa.com</td>
                        <td>Usuario Normal</td>
                        <td>1</td>
                        <td>0</td>
                        <td>5</td>
                        <td>2023-09-28</td>
                        <td>2023-09-29</td>
                        <td>2023-11-01</td>
                        <td>2023-11-01</td>
                        <td>user1</td>
                        <td>user1</td>
                        <td>admin7</td>
                        <td>10:00:00</td>
                        <td>11:00:00</td>
                        <td>11:30:00</td>
                        <td>13:00:00</td>
                    </tr>
                    <!-- Más filas aquí -->
                </tbody>
            </table>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>

