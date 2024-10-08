package Modelo;

import conexion.Conexion;

import static conexion.Conexion.getConexion;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDao implements IUsuario {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r;
    UsuarioDto u = new UsuarioDto();

    @Override
    public List<UsuarioDto> listar(String codUsuario) {
        ArrayList<UsuarioDto> list = new ArrayList<>();
        String sql;

        // Consulta según el codUsuario
        if (codUsuario.equals("ADM1")) {
            sql = "SELECT * FROM usuarios";
        } else {
            sql = "SELECT * FROM usuarios WHERE Permisos = 'UsuarioNormal'";
        }

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
        } catch (SQLException e) {
            e.printStackTrace(); // Considera registrar el error en un log
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
    public boolean add(UsuarioDto usu, String codUsuarioCreador) {
        String permisos = usu.getPermisos();

        // Verificar si el creador es ADM1 y si está asignando un permiso válido
        if (codUsuarioCreador.equals("ADM1")) {
            // ADM1 solo puede asignar "Administrador" o "UsuarioNormal"
            if (!permisos.equals("Administrador") && !permisos.equals("UsuarioNormal")) {
                System.out.println("ADM1 solo puede asignar los roles 'Administrador' o 'UsuarioNormal'.");
                return false;
            }
        } else {
            // Otros administradores solo pueden asignar "UsuarioNormal"
            if (!permisos.equals("UsuarioNormal")) {
                System.out.println("El usuario " + codUsuarioCreador + " solo puede asignar el rol 'UsuarioNormal'.");
                return false;
            }
        }

        String sql = "INSERT INTO usuarios (Usuario, Password, Nombres, Apellidos, Email, Permisos, Creado_Por) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usu.getUsuario());
            ps.setString(2, usu.getPassword());
            ps.setString(3, usu.getNombres());
            ps.setString(4, usu.getApellidos());
            ps.setString(5, usu.getEmail());
            ps.setString(6, permisos); // Permiso ya validado previamente
            ps.setString(7, codUsuarioCreador);

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
    public boolean edit(UsuarioDto usu, String codUsuarioEditor) {
        String sql = "UPDATE usuarios SET Usuario = ?, Password = ?, Nombres = ?, Apellidos = ?, Email = ?, "
                + (codUsuarioEditor.equals("ADM1") ? "Permisos = ?, " : "")
                + // Solo ADM1 puede modificar permisos
                "Estado = ?, Modificado_Por = ? WHERE idUsuario = ?";

        try {
            con = cn.getConexion();  // Obteniendo la conexión
            ps = con.prepareStatement(sql);

            // Asignando los valores a los parámetros
            ps.setString(1, usu.getUsuario());   // Asigna el valor de "Usuario"
            ps.setString(2, usu.getPassword());  // Asigna el valor de "Password"
            ps.setString(3, usu.getNombres());   // Asigna el valor de "Nombres"
            ps.setString(4, usu.getApellidos()); // Asigna el valor de "Apellidos"
            ps.setString(5, usu.getEmail());     // Asigna el valor de "Email"

            int parameterIndex = 6;
            if (codUsuarioEditor.equals("ADM1")) {
                ps.setString(parameterIndex, usu.getPermisos());  // Solo ADM1 puede asignar permisos
                parameterIndex++;
            }

            ps.setInt(parameterIndex, usu.getEstado());           // Asigna el valor de "Estado"
            ps.setString(parameterIndex + 1, codUsuarioEditor);   // Agrega el codUsuario del editor
            ps.setInt(parameterIndex + 2, usu.getIdUsuario());    // Asigna el valor de "idUsuario" para la condición WHERE

            int rowsUpdated = ps.executeUpdate();  // Ejecuta la consulta

            return rowsUpdated > 0;  // Retorna true si se actualizó al menos una fila

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

    @Override
    public boolean eliminar(UsuarioDto usu, String codUsuarioEliminador) {
        String sql = "UPDATE usuarios SET Estado = ?, Eliminado_Por = ?, Fec_Eliminacion = NOW() WHERE idUsuario = ?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);

            // Cambia el estado del usuario a 0 para indicar eliminación lógica
            ps.setInt(1, 0);  // Estado 0 = Eliminado
            ps.setString(2, codUsuarioEliminador); // Usuario que realiza la eliminación
            ps.setInt(3, usu.getIdUsuario());

            int rowsUpdated = ps.executeUpdate();
            return rowsUpdated > 0;  // Retorna true si se actualizaron filas

        } catch (Exception e) {
            e.printStackTrace(); // Manejo de errores
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
        return false;  // Retorna false si algo falla
    }

    public List<UsuarioDto> buscarPorCodUsuario(String codUsuario, String codUsuarioSession) {
        List<UsuarioDto> lista = new ArrayList<>();
        String sql;

        // Verifica si el usuario en sesión es ADM1
        if ("ADM1".equals(codUsuarioSession)) {
            sql = "SELECT * FROM usuarios WHERE CodUsuario LIKE ?";
        } else {
            // Si no es ADM1, solo permite buscar usuarios normales
            sql = "SELECT * FROM usuarios WHERE CodUsuario LIKE ? AND Permisos != 'Administrador'";
        }

        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + codUsuario + "%"); // Utiliza LIKE para permitir coincidencias parciales
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
                lista.add(usu);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return lista;
    }
    
    @Override
    public int validar(UsuarioDto usuario) {
        String sql = "SELECT * FROM usuarios WHERE Usuario=? AND Password=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, usuario.getPassword());
            rs = ps.executeQuery();

            if (rs.next()) {
                // Verificar el estado del usuario
                int estado = rs.getInt("Estado"); // Asegúrate que este campo exista en la tabla

                if (estado == 0) {
                    return 4; // Usuario eliminado
                } else if (estado == 2) {
                    return 5; // Usuario suspendido
                }

                // Asignar valores a usuario DTO
                usuario.setEmail(rs.getString("Email")); // Asegúrate que este campo exista en la tabla
                usuario.setNombres(rs.getString("Nombres")); // Asegúrate que este campo exista en la tabla
                usuario.setPermisos(rs.getString("Permisos")); // Asegúrate que este campo exista en la tabla
                usuario.setCodUsuario(rs.getString("CodUsuario")); // Asegúrate que este campo exista en la tabla

                return 1; // Usuario y contraseña correctos
            } else {
                return 2; // Contraseña incorrecta
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Para depuración
            return 3; // Error o usuario no existe
        } finally {
            // Cierra los recursos
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Para depuración
            }
        }
    }

    // Método para actualizar estado de "En línea" del usuario
    @Override
    public void actualizarEstadoEnLinea(String usuario, boolean enLinea) {
        String sql = "UPDATE usuarios SET EnLinea=? WHERE Usuario=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setBoolean(1, enLinea);
            ps.setString(2, usuario);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void suspenderUsuario(String usuario) {
        String sql = "UPDATE usuarios SET Estado=2 WHERE Usuario=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    // Método para verificar el estado de un usuario
    public int obtenerEstado(String usuario) {
        String sql = "SELECT Estado FROM usuarios WHERE Usuario=?";
        try {
            con = cn.getConexion();
            ps = con.prepareStatement(sql);
            ps.setString(1, usuario);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("Estado"); // Retorna el estado (0, 1, o 2)
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1; // Error al obtener el estado
    }
}
