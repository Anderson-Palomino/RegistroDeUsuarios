
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Registro de usuarios</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>

<body>
    <div class="container mt-5">
        <h2>Registro de usuarios</h2>
        <form>
            <div class="mb-3">
                <label for="idUsuario" class="form-label">ID Usuario</label>
                <input type="number" class="form-control" id="idUsuario" placeholder="Correlativo desde 10000000x">
            </div>
            <div class="mb-3">
                <label for="codUsuario" class="form-label">Código de Usuario</label>
                <input type="text" class="form-control" id="codUsuario">
            </div>
            <div class="mb-3">
                <label for="usuario" class="form-label">Usuario</label>
                <input type="text" class="form-control" id="usuario">
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Contraseña</label>
                <input type="password" class="form-control" id="password">
            </div>
            <div class="mb-3">
                <label for="nombres" class="form-label">Nombres</label>
                <input type="text" class="form-control" id="nombres">
            </div>
            <div class="mb-3">
                <label for="apellidos" class="form-label">Apellidos</label>
                <input type="text" class="form-control" id="apellidos">
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">Email</label>
                <input type="email" class="form-control" id="email">
            </div>
            <div class="mb-3">
                <label for="permisos" class="form-label">Permisos</label>
                <input type="text" class="form-control" id="permisos">
            </div>
            <div class="mb-3">
                <label for="estado" class="form-label">Estado</label>
                <input type="text" class="form-control" id="estado">
            </div>
            <div class="mb-3 form-check">
                <input type="checkbox" class="form-check-input" id="enlinea">
                <label class="form-check-label" for="enlinea">¿En línea?</label>
            </div>
            <div class="mb-3">
                <label for="numIngresos" class="form-label">Número de Ingresos</label>
                <input type="number" class="form-control" id="numIngresos">
            </div>
            <div class="mb-3">
                <label for="fecCreacion" class="form-label">Fecha de Creación</label>
                <input type="date" class="form-control" id="fecCreacion">
            </div>
            <div class="mb-3">
                <label for="fecModificacion" class="form-label">Fecha de Modificación</label>
                <input type="date" class="form-control" id="fecModificacion">
            </div>
            <div class="mb-3">
                <label for="fecEliminacion" class="form-label">Fecha de Eliminación</label>
                <input type="date" class="form-control" id="fecEliminacion">
            </div>
            <div class="mb-3">
                <label for="fecUltimoAcceso" class="form-label">Fecha de Último Acceso</label>
                <input type="date" class="form-control" id="fecUltimoAcceso">
            </div>
            <div class="mb-3">
                <label for="creadoPor" class="form-label">Creado por</label>
                <input type="text" class="form-control" id="creadoPor">
            </div>
            <div class="mb-3">
                <label for="modificadoPor" class="form-label">Modificado por</label>
                <input type="text" class="form-control" id="modificadoPor">
            </div>
            <div class="mb-3">
                <label for="eliminadaPor" class="form-label">Eliminado por</label>
                <input type="text" class="form-control" id="eliminadaPor">
            </div>
            <div class="mb-3">
                <label for="horaCreacion" class="form-label">Hora de Creación</label>
                <input type="time" class="form-control" id="horaCreacion">
            </div>
            <div class="mb-3">
                <label for="horaModificacion" class="form-label">Hora de Modificación</label>
                <input type="time" class="form-control" id="horaModificacion">
            </div>
            <div class="mb-3">
                <label for="horaEliminacion" class="form-label">Hora de Eliminación</label>
                <input type="time" class="form-control" id="horaEliminacion">
            </div>
            <div class="mb-3">
                <label for="horaUltimoAcceso" class="form-label">Hora de Último Acceso</label>
                <input type="time" class="form-control" id="horaUltimoAcceso">
            </div>
            <button type="submit" class="btn btn-primary">Registrar</button>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous">
    </script>
</body>

</html>
