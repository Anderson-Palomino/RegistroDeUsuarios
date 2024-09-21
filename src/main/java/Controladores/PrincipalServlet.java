/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controladores;

import Modelo.UsuarioDao;
import Modelo.UsuarioDto;

import java.io.IOException;
import java.io.PrintWriter;
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
            dao.add(u);
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
