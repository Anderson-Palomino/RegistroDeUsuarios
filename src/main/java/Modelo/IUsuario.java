package Modelo;
import java.util.List;
public interface IUsuario {
    public int validar (UsuarioDto usu);
    public List listar(String codUsuario);
    public UsuarioDto list(int idUsuario);
    public boolean add(UsuarioDto usu, String codUsuarioCreador);
    public boolean edit(UsuarioDto usu, String codUsuarioEditor);
    public boolean eliminar(UsuarioDto usu, String codUsuarioEliminador);
}
