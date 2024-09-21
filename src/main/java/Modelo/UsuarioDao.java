package Modelo;

import conexion.Conexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao implements IUsuario {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    UsuarioDto u = new UsuarioDto();

    @Override
    public List listar() {
        ArrayList<UsuarioDto> list = new ArrayList<>();
        String sql = "select * from usuarios";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                UsuarioDto usu = new UsuarioDto();
                usu.setItemAi(rs.getInt("ItemAI"));
                usu.setIdUsuario(rs.getInt("idUsuario"));
                usu.setCodUsuario(rs.getString("CodUsuario"));
                usu.setUsuario(rs.getString("Usuario"));
                usu.setPassword(rs.getString("Password"));
                usu.setNombres(rs.getString("Nombres"));
                usu.setApellidos(rs.getString("Apellidos"));
                usu.setEmail(rs.getString("Email"));
                usu.setPermisos(rs.getString("Permisos"));
                usu.setEstado(rs.getInt("Estado"));
                usu.setEnlinea(rs.getBoolean("EnLinea"));
                usu.setNumIngresos(rs.getObject("Num_Ingresos") != null ? rs.getInt("Num_Ingresos") : 0);
                usu.setFecCreacion(rs.getDate("Fec_Creacion").toLocalDate());
                usu.setFecModificacion(rs.getDate("Fec_Modificacion") != null ? rs.getDate("Fec_Modificacion").toLocalDate() : null);
                usu.setFecEliminacion(rs.getDate("Fec_Eliminacion") != null ? rs.getDate("Fec_Eliminacion").toLocalDate() : null);
                usu.setFecUltimoAcceso(rs.getDate("Fec_UltimoAcceso") != null ? rs.getDate("Fec_UltimoAcceso").toLocalDate() : null);
                usu.setCreadoPor(rs.getString("Creado_Por") != null ? rs.getString("Creado_Por") : "");
                usu.setModificadoPor(rs.getString("Modificado_Por") != null ? rs.getString("Modificado_Por") : "");
                usu.setEliminadaPor(rs.getString("Eliminado_Por") != null ? rs.getString("Eliminado_Por") : "");
                usu.setHoraCreacion(rs.getTime("Hora_Creacion").toLocalTime());
                usu.setHoraModificacion(rs.getTime("Hora_Modificacion") != null ? rs.getTime("Hora_Modificacion").toLocalTime() : null);
                usu.setHoraEliminacion(rs.getTime("Hora_Eliminacion") != null ? rs.getTime("Hora_Eliminacion").toLocalTime() : null);
                usu.setHoraUltimoAcceso(rs.getTime("Hora_UltimoAcceso") != null ? rs.getTime("Hora_UltimoAcceso").toLocalTime() : null);
                list.add(usu);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public UsuarioDto list(int idUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(UsuarioDto usu) {
        String sql = "INSERT INTO usuarios (Usuario, Password, Nombres, Apellidos, Email, Permisos) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usu.getUsuario());
            ps.setString(2, usu.getPassword());
            ps.setString(3, usu.getNombres());
            ps.setString(4, usu.getApellidos());
            ps.setString(5, usu.getEmail());
            ps.setString(6, usu.getPermisos());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0; // Devuelve true si se insertó al menos un registro
        } catch (Exception e) {
            e.printStackTrace(); // Imprimir error para depuración
        } finally {
            try {
                if (ps != null) ps.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace(); // Manejo de excepciones al cerrar
            }
        }
        return false; // Si no se insertó nada, devuelve false
    }

    @Override
    public boolean edit(UsuarioDto usu) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean eliminar(int idUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}