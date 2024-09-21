package Modelo;
import java.util.List;
public interface IUsuario {
    public List listar();
    public UsuarioDto list(int idUsuario);
    public boolean add(UsuarioDto usu);
    public boolean edit(UsuarioDto usu);
    public boolean eliminar(UsuarioDto usu);
}
