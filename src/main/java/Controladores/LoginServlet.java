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

            // Obtener el contador de intentos fallidos y el tiempo de bloqueo de la sesión 
            Integer intentosFallidos = (Integer) request.getSession().getAttribute("intentosFallidos");
            Long tiempoBloqueo = (Long) request.getSession().getAttribute("tiempoBloqueo");

            if (intentosFallidos == null) {
                intentosFallidos = 0;
            }

            // Si ya se ha bloqueado el acceso, verificar si han pasado los 30 segundos 
            if (tiempoBloqueo != null) {
                long tiempoRestante = (System.currentTimeMillis() - tiempoBloqueo) / 1000;
                if (tiempoRestante < 30) {
                    // Mostrar mensaje de tiempo restante 
                    request.setAttribute("mensajeError", "Ha fallado 3 veces. Espere " + (30 - tiempoRestante) + " segundos antes de intentarlo de nuevo.");
                    request.getRequestDispatcher("/vistas/login.jsp").forward(request, response);
                    return;
                } else {
                    // No reiniciar los intentos, pero eliminar el tiempo de bloqueo 
                    request.getSession().removeAttribute("tiempoBloqueo");
                }
            }

            // Validar el usuario 
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

                // Resetear los intentos fallidos porque el login fue exitoso 
                request.getSession().removeAttribute("intentosFallidos");

                // Redirigir dependiendo de los permisos del usuario 
                if (permisos != null && permisos.equalsIgnoreCase("Administrador")) {
                    request.getRequestDispatcher("/vistas/Listar.jsp").forward(request, response);
                } else if (permisos != null && permisos.equalsIgnoreCase("UsuarioNormal")) {
                    request.getRequestDispatcher("/vistas/home.jsp").forward(request, response);
                }

            } else if (r == 2) {
                // Contraseña incorrecta 
                intentosFallidos++;
                request.getSession().setAttribute("intentosFallidos", intentosFallidos);

                if (intentosFallidos >= 4) {
                    // Suspender al usuario 
                    dao.suspenderUsuario(usuario); // Asegúrate de implementar este método en UsuarioDao
                    request.setAttribute("mensajeError", "Tu cuenta ha sido suspendida. Contacta al administrador.");
                } else if (intentosFallidos == 3) {
                    // Bloquear el login por 30 segundos
                    request.getSession().setAttribute("tiempoBloqueo", System.currentTimeMillis());
                    request.setAttribute("mensajeError", "Has fallado 3 veces. Debes esperar 30 segundos para volver a intentarlo. Si "
                            + "fallas una vez más, tu cuenta será suspendida.");
                } else {
                    String mensajeError = "La contraseña es incorrecta. Intento " + intentosFallidos + " de 4.";
                    if (intentosFallidos == 2) {
                        // Mostrar advertencia cuando esté en el segundo intento
                        mensajeError += "";
                    }
                    request.setAttribute("mensajeError", mensajeError);
                }
                request.getRequestDispatcher("/vistas/login.jsp").forward(request, response);

            } else if (r == 3) {
                // Usuario no existe 
                request.setAttribute("mensajeError", "El usuario no existe");
                request.getRequestDispatcher("/vistas/login.jsp").forward(request, response);
            } else if (r == 4) {
                // Usuario eliminado
                request.setAttribute("mensajeError", "Su cuenta ha sido eliminada. Comuníquese con el administrador.");
                request.getRequestDispatcher("/vistas/login.jsp").forward(request, response);
            } else if (r == 5) {
                // Usuario suspendido
                request.setAttribute("mensajeError", "Su cuenta está suspendida. Comuníquese con el administrador.");
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
