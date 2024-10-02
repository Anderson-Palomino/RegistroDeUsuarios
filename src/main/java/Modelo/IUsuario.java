package Modelo;
import java.util.List;
public interface IUsuario {
    public List listar(String codUsuario);
    public UsuarioDto list(int idUsuario);
    public boolean add(UsuarioDto usu, String codUsuarioCreador);
    public boolean edit(UsuarioDto usu, String codUsuarioEditor);
    public boolean eliminar(UsuarioDto usu, String codUsuarioEliminador);
    public int validar (UsuarioDto usuario);
    public void actualizarEstadoEnLinea(String usuario, boolean enLinea);
    public void suspenderUsuario(String usuario);
    public int obtenerEstado(String usuario);
}
