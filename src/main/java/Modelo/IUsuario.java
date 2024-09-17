package Modelo;
import java.util.List;
public interface IUsuario {
    void agregarUsuario(UsuarioDto usuario);//Crear usuarios
    UsuarioDto listarUsuarioPorId(int idUsuario);//Leerlos por Id
    List<UsuarioDto> listarTodosLosUsuarios();//Leer todos los usuarios
    void actualizarUsuario();//Actualizarlos
    void eliminarUsuario();//Eliminarlos
}
