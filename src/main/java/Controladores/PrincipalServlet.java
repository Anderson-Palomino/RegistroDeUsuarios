/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controladores;

import Modelo.UsuarioDao;
import Modelo.UsuarioDto;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ander
 */
@WebServlet(name = "PrincipalServlet", urlPatterns = {"/PrincipalServlet"})
public class PrincipalServlet extends HttpServlet {

    String listar = "vistas/Listar.jsp";
    String add = "vistas/add.jsp";
    String edit = "vistas/edit.jsp";
    UsuarioDto u = new UsuarioDto();
    UsuarioDao dao = new UsuarioDao();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet principal</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet principal at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso = "";
        String action = request.getParameter("accion");

        if (action.equalsIgnoreCase("listar")) {
            acceso = listar;
        } else if (action.equalsIgnoreCase("add")) {
            acceso = add;
        } else if (action.equalsIgnoreCase("buscar")) {
            String codUsuarioBuscar = request.getParameter("txtBuscar");
            String codUsuarioSession = (String) request.getSession().getAttribute("codUsuario");

            if (codUsuarioBuscar != null && !codUsuarioBuscar.isEmpty()) {
                // Llama al método del DAO que busca los usuarios por código de usuario
                List<UsuarioDto> listaUsuarios = dao.buscarPorCodUsuario(codUsuarioBuscar, codUsuarioSession);
                request.setAttribute("usuarios", listaUsuarios);
            } else {
                request.setAttribute("usuarios", dao.listar(codUsuarioSession)); // Lista todos los usuarios si no hay búsqueda
            }

            acceso = listar; // Redirige a la página de listado de usuarios con los resultados
        } else if (action.equalsIgnoreCase("Agregar")) {
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
            String nombres = request.getParameter("nombres");
            String apellidos = request.getParameter("apellidos");
            String email = request.getParameter("email");
            String permisos = request.getParameter("permisos");

            u.setUsuario(usuario);
            u.setPassword(password);
            u.setNombres(nombres);
            u.setApellidos(apellidos);
            u.setEmail(email);
            u.setPermisos(permisos);

            // Obtener el codUsuario del creador desde la sesión
            String codUsuarioCreador = (String) request.getSession().getAttribute("codUsuario");
            dao.add(u, codUsuarioCreador); // Pasar el codUsuarioCreador
            acceso = listar;
        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("idusu", request.getParameter("idUsuario"));
            acceso = edit;
        } else if (action.equalsIgnoreCase("Actualizar")) {
            int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            String usuario = request.getParameter("usuario");
            String password = request.getParameter("password");
            String nombres = request.getParameter("nombres");
            String apellidos = request.getParameter("apellidos");
            String email = request.getParameter("email");
            int estado = Integer.parseInt(request.getParameter("estado"));

            u.setIdUsuario(idUsuario);
            u.setUsuario(usuario);
            u.setPassword(password);
            u.setNombres(nombres);
            u.setApellidos(apellidos);
            u.setEmail(email);
            u.setEstado(estado);

            // Obtener el codUsuario del editor desde la sesión
            String codUsuarioEditor = (String) request.getSession().getAttribute("codUsuario");

            // Si el usuario en sesión es ADM1, permitir que modifique los permisos
            if (codUsuarioEditor.equals("ADM1")) {
                String permisos = request.getParameter("permisos");
                u.setPermisos(permisos);
            } else {
                // Mantener los permisos actuales si no es ADM1
                UsuarioDto usuarioExistente = dao.list(idUsuario); // Obtener los permisos actuales
                u.setPermisos(usuarioExistente.getPermisos());
            }

            dao.edit(u, codUsuarioEditor); // Pasar el codUsuarioEditor
            acceso = listar;
        } else if (action.equalsIgnoreCase("eliminar")) {
            int idUsuario = Integer.parseInt(request.getParameter("idUsuario"));
            u.setIdUsuario(idUsuario);

            // Obtener el codUsuario del eliminador desde la sesión
            String codUsuarioEliminador = (String) request.getSession().getAttribute("codUsuario");
            dao.eliminar(u, codUsuarioEliminador); // Pasar el codUsuarioEliminador
            acceso = listar;
        }

        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
