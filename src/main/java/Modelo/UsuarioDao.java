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
        ArrayList<UsuarioDto> list = new ArrayList<>();
        String sql = "select * from usuarios where idUsuario=" + idUsuario;
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                u.setItemAi(rs.getInt("ItemAI"));
                u.setIdUsuario(rs.getInt("idUsuario"));
                u.setCodUsuario(rs.getString("CodUsuario"));
                u.setUsuario(rs.getString("Usuario"));
                u.setPassword(rs.getString("Password"));
                u.setNombres(rs.getString("Nombres"));
                u.setApellidos(rs.getString("Apellidos"));
                u.setEmail(rs.getString("Email"));
                u.setPermisos(rs.getString("Permisos"));
                u.setEstado(rs.getInt("Estado"));
                u.setEnlinea(rs.getBoolean("EnLinea"));
                u.setNumIngresos(rs.getObject("Num_Ingresos") != null ? rs.getInt("Num_Ingresos") : 0);
                u.setFecCreacion(rs.getDate("Fec_Creacion").toLocalDate());
                u.setFecModificacion(rs.getDate("Fec_Modificacion") != null ? rs.getDate("Fec_Modificacion").toLocalDate() : null);
                u.setFecEliminacion(rs.getDate("Fec_Eliminacion") != null ? rs.getDate("Fec_Eliminacion").toLocalDate() : null);
                u.setFecUltimoAcceso(rs.getDate("Fec_UltimoAcceso") != null ? rs.getDate("Fec_UltimoAcceso").toLocalDate() : null);
                u.setCreadoPor(rs.getString("Creado_Por") != null ? rs.getString("Creado_Por") : "");
                u.setModificadoPor(rs.getString("Modificado_Por") != null ? rs.getString("Modificado_Por") : "");
                u.setEliminadaPor(rs.getString("Eliminado_Por") != null ? rs.getString("Eliminado_Por") : "");
                u.setHoraCreacion(rs.getTime("Hora_Creacion").toLocalTime());
                u.setHoraModificacion(rs.getTime("Hora_Modificacion") != null ? rs.getTime("Hora_Modificacion").toLocalTime() : null);
                u.setHoraEliminacion(rs.getTime("Hora_Eliminacion") != null ? rs.getTime("Hora_Eliminacion").toLocalTime() : null);
                u.setHoraUltimoAcceso(rs.getTime("Hora_UltimoAcceso") != null ? rs.getTime("Hora_UltimoAcceso").toLocalTime() : null);
            }
        } catch (Exception e) {
        }
        return u;
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
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Manejo de excepciones al cerrar
            }
        }
        return false; // Si no se insertó nada, devuelve false
    }

    @Override
    public boolean edit(UsuarioDto usu) {
        String sql = "UPDATE usuarios SET Usuario = ?, Password = ?, Nombres = ?, Apellidos = ?, Email = ?, Permisos = ? WHERE idUsuario = ?";
        try {
            con = cn.getConexion();  // Obteniendo la conexión
            ps = con.prepareStatement(sql);

            // Asignando los valores a los parámetros
            ps.setString(1, usu.getUsuario());   // Asigna el valor de "Usuario"
            ps.setString(2, usu.getPassword());  // Asigna el valor de "Password"
            ps.setString(3, usu.getNombres());   // Asigna el valor de "Nombres"
            ps.setString(4, usu.getApellidos()); // Asigna el valor de "Apellidos"
            ps.setString(5, usu.getEmail());     // Asigna el valor de "Email"
            ps.setString(6, usu.getPermisos());  // Asigna el valor de "Permisos"
            ps.setInt(7, usu.getIdUsuario());    // Asigna el valor de "idUsuario" para la condición WHERE

            int rowsUpdated = ps.executeUpdate();  // Ejecuta la consulta

            // Si se actualizó al menos una fila, retorna true
            return rowsUpdated > 0;

        } catch (Exception e) {
            e.printStackTrace();  // Muestra el error si ocurre
        } finally {
            try {
                if (ps != null) {
                    ps.close();  // Cierra el PreparedStatement
                }
                if (con != null) {
                    con.close();  // Cierra la conexión
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return false;  // Retorna false si la operación falló
    }

    public boolean eliminar(UsuarioDto usu) {
        String sql="UPDATE usuarios SET Estado=? WHERE idUsuario = ?";
        try {
            con=cn.getConexion();
            ps=con.prepareStatement(sql);
            
            ps.setInt(1, usu.getEstado());
            ps.setInt(2, usu.getIdUsuario());  
            
            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;
        } catch (Exception e) {
        }finally {
            try {
                if (ps != null) {
                    ps.close();  // Cierra el PreparedStatement
                }
                if (con != null) {
                    con.close();  // Cierra la conexión
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return false;
    }

}
