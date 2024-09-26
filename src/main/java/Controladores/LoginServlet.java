package Controladores;

import Modelo.UsuarioDao;
import Modelo.UsuarioDto;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    UsuarioDao dao = new UsuarioDao();
    UsuarioDto u = new UsuarioDto();
    int r;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");

        if (accion.equals("Ingresar")) {
            String usuario = request.getParameter("txtUsuario");
            String password = request.getParameter("txtPassword");
            u.setUsuario(usuario);
            u.setPassword(password);

            // Validamos el usuario y obtenemos el resultado
            r = dao.validar(u);

            if (r == 1) {
                // Si el usuario es válido y la contraseña es correcta
                String email = u.getEmail();
                String nombres = u.getNombres();
                String permisos = u.getPermisos();
                String codUsuario = u.getCodUsuario();

                // Almacenar datos del usuario en la sesión
                request.getSession().setAttribute("usuario", usuario);
                request.getSession().setAttribute("email", email);
                request.getSession().setAttribute("permisos", permisos);
                request.getSession().setAttribute("nombres", nombres);
                request.getSession().setAttribute("codUsuario", codUsuario);

                dao.actualizarEstadoEnLinea(usuario, true);

                // Redirigir dependiendo de los permisos del usuario
                if (permisos.equalsIgnoreCase("Administrador")) {
                    request.getRequestDispatcher("/vistas/Listar.jsp").forward(request, response);
                } else if (permisos.equalsIgnoreCase("UsuarioNormal")) {
                    request.getRequestDispatcher("/vistas/home.jsp").forward(request, response);
                }

            } else if (r == 2) {
                // Contraseña incorrecta
                request.setAttribute("mensajeError", "La contraseña es incorrecta");
                request.getRequestDispatcher("/vistas/login.jsp").forward(request, response);

            } else if (r == 3) {
                // Usuario no existe
                request.setAttribute("mensajeError", "El usuario y la contraseña son incorrectos");
                request.getRequestDispatcher("/vistas/login.jsp").forward(request, response);

            } else {
                // Otro tipo de error o usuario inactivo
                request.setAttribute("mensajeError", "Error en la autenticación o el usuario está inactivo");
                request.getRequestDispatcher("/vistas/login.jsp").forward(request, response);
            }
        } else if (accion.equals("Salir")) {
            // Actualizar EnLinea a 0 cuando el usuario salga
            String usuario = (String) request.getSession().getAttribute("usuario");
            if (usuario != null) {
                dao.actualizarEstadoEnLinea(usuario, false);
            }
            // Invalida la sesión y redirige a login
            request.getSession().invalidate();
            request.getRequestDispatcher("/vistas/login.jsp").forward(request, response);
        } else {
            // Si no hay acción definida, redirige al login
            request.getRequestDispatcher("/vistas/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}
