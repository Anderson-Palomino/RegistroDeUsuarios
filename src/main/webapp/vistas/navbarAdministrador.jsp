<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/navbar.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet"> <!-- Font Awesome -->
</head>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/vistas/home.jsp">
            <i class="fas fa-home"></i> Home <!-- Ícono de "home" -->
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/PrincipalServlet?accion=listar">
                        <i class="fas fa-chart-line"></i> Dashboard <!-- Ícono de "dashboard" -->
                    </a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <img src="${pageContext.request.contextPath}/img/user2.png" height="40" width="40" class="rounded-circle" alt="User Image"> ${sessionScope.usuario}
                    </a>
                    <ul class="dropdown-menu dropdown-menu-end" aria-labelledby="userDropdown">
                        <li><a class="dropdown-item" href="#"><i class="fas fa-envelope"></i> ${sessionScope.email}</a></li> <!-- Ícono de "envelope" para el email -->
                        <li><hr class="dropdown-divider"></li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/LoginServlet?accion=Salir"><i class="fas fa-sign-out-alt"></i> Salir</a></li> <!-- Ícono de "sign-out" para salir -->
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>
