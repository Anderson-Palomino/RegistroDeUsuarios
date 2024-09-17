package Modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao implements IUsuario {

    private Connection conexion;

    public UsuarioDao(Connection conexion) {
        this.conexion = conexion;
    }

    @Override
    public void agregarUsuario(UsuarioDto usuario) {
//        String sql = "INSERT INTO usuarios (IdUsuario, CodUsuario, Usuario, Password, Nombres, Apellidos, Email, Permisos, Estado, Enlinea, Num_Ingresos,"
//                + "Fec_Creacion, Fec_Modificacion, Fec_Eliminacion, Fec_UltimoAcceso, Creado_Por, Modificado_Por, Eliminado_Por, Hora_Creacion, Hora_Modificacion, Hora_Eliminacion, Hora_UltimoAcceso)"
//                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    }

    @Override
    public UsuarioDto listarUsuarioPorId(int idUsuario) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<UsuarioDto> listarTodosLosUsuarios() {
        List<UsuarioDto> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";
        try (Statement st = conexion.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                UsuarioDto usuario = new UsuarioDto(
                        rs.getInt("IteamA"),
                        rs.getInt("IdUsuario"),
                        rs.getString("CodUsuario"),
                        rs.getString("Usuario"),
                        rs.getString("Password"),
                        rs.getString("Nombres"),
                        rs.getString("Apellidos"),
                        rs.getString("Email"),
                        rs.getString("Permisos"),
                        rs.getString("Estado"),
                        rs.getBoolean("EnLinea"),
                        rs.getInt("Num_Ingresos"),
                        rs.getDate("Fec_Creacion").toLocalDate(),
                        rs.getDate("Fec_Modificacion").toLocalDate(),
                        rs.getDate("Fec_Eliminacion").toLocalDate(),
                        rs.getDate("Fec_UltimoAcceso").toLocalDate(),
                        rs.getString("Creado_Por"),
                        rs.getString("Modificado_Por"),
                        rs.getString("Eliminado_Por"),
                        rs.getTime("Hora_Creacion").toLocalTime(),
                        rs.getTime("Hora_Modificacion").toLocalTime(),
                        rs.getTime("Hora_Eliminacion").toLocalTime(),
                        rs.getTime("Hora_UltimoAcceso").toLocalTime()
                );
                usuarios.add(usuario);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuarios;
    }

    @Override
    public void actualizarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
