package Modelo;

import java.time.LocalDate;
import java.time.LocalTime;

public class UsuarioDto {

    private int itemAi; // Correlativo único
    private int idUsuario; // Correlativo desde 10000000x
    private String codUsuario;
    private String usuario;
    private String password;
    private String nombres;
    private String apellidos;
    private String email;
    private String permisos;
    private int estado;
    private boolean enlinea;
    private int numIngresos;
    private LocalDate fecCreacion;
    private LocalDate fecModificacion;
    private LocalDate fecEliminacion;
    private LocalDate fecUltimoAcceso;
    private String creadoPor;
    private String modificadoPor;
    private String eliminadaPor;
    private LocalTime horaCreacion;
    private LocalTime horaModificacion;
    private LocalTime horaEliminacion;
    private LocalTime horaUltimoAcceso;

    // Constructores
    public UsuarioDto() {
    }

    //Pensando en poder listar todo el contenido de la tabla
    public UsuarioDto(int idUsuario, String codUsuario, String usuario, String password, String nombres, String apellidos, String email, String permisos, int estado, boolean enlinea, int numIngresos, LocalDate fecCreacion, LocalDate fecModificacion, LocalDate fecEliminacion, LocalDate fecUltimoAcceso, String creadoPor, String modificadoPor, String eliminadaPor, LocalTime horaCreacion, LocalTime horaModificacion, LocalTime horaEliminacion, LocalTime horaUltimoAcceso) {
        this.idUsuario = idUsuario;
        this.codUsuario = codUsuario;
        this.usuario = usuario;
        this.password = password;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.permisos = permisos;
        this.estado = estado;
        this.enlinea = enlinea;
        this.numIngresos = numIngresos;
        this.fecCreacion = fecCreacion;
        this.fecModificacion = fecModificacion;
        this.fecEliminacion = fecEliminacion;
        this.fecUltimoAcceso = fecUltimoAcceso;
        this.creadoPor = creadoPor;
        this.modificadoPor = modificadoPor;
        this.eliminadaPor = eliminadaPor;
        this.horaCreacion = horaCreacion;
        this.horaModificacion = horaModificacion;
        this.horaEliminacion = horaEliminacion;
        this.horaUltimoAcceso = horaUltimoAcceso;
    }

    public String getEstadoTexto() {
        switch (this.estado) {
            case 0:
                return "Eliminado";
            case 1:
                return "Activo";
            case 2:
                return "Suspendido";
            default:
                return "Desconocido";
        }
    }

    public String getEnLineaTexto() {
        return this.enlinea ? "Online" : "Offline";
    }

    public String getFecModificacionTexto() {
        return (this.fecModificacion != null) ? this.fecModificacion.toString() : "No hay registros";
    }

    public String getFecEliminacionTexto() {
        return (this.fecEliminacion != null) ? this.fecEliminacion.toString() : "No hay registros";
    }

    public String getFecUltimoAccesoTexto() {
        return (this.fecUltimoAcceso != null) ? this.fecUltimoAcceso.toString() : "No hay registros";
    }

    public String getHoraModificacionTexto() {
        return (this.horaModificacion != null) ? this.horaModificacion.toString() : "No hay registros";
    }

    public String getHoraEliminacionTexto() {
        return (this.horaEliminacion != null) ? this.horaEliminacion.toString() : "No hay registros";
    }

    public String getHoraUltimoAccesoTexto() {
        return (this.horaUltimoAcceso != null) ? this.horaUltimoAcceso.toString() : "No hay registros";
    }

    public String getModificadoPorTexto() {
        return (this.modificadoPor != null && !this.modificadoPor.isEmpty()) ? this.modificadoPor : "No hay registros";
    }

    public String getEliminadaPorTexto() {
        return (this.eliminadaPor != null && !this.eliminadaPor.isEmpty()) ? this.eliminadaPor : "No hay registros";
    }

    public int getItemAi() {
        return itemAi;
    }

    public void setItemAi(int itemAi) {
        this.itemAi = itemAi;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(String codUsuario) {
        this.codUsuario = codUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPermisos() {
        return permisos;
    }

    public void setPermisos(String permisos) {
        this.permisos = permisos;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public boolean isEnlinea() {
        return enlinea;
    }

    public void setEnlinea(boolean enlinea) {
        this.enlinea = enlinea;
    }

    public int getNumIngresos() {
        return numIngresos;
    }

    public void setNumIngresos(int numIngresos) {
        this.numIngresos = numIngresos;
    }

    public LocalDate getFecCreacion() {
        return fecCreacion;
    }

    public void setFecCreacion(LocalDate fecCreacion) {
        this.fecCreacion = fecCreacion;
    }

    public LocalDate getFecModificacion() {
        return fecModificacion;
    }

    public void setFecModificacion(LocalDate fecModificacion) {
        this.fecModificacion = fecModificacion;
    }

    public LocalDate getFecEliminacion() {
        return fecEliminacion;
    }

    public void setFecEliminacion(LocalDate fecEliminacion) {
        this.fecEliminacion = fecEliminacion;
    }

    public LocalDate getFecUltimoAcceso() {
        return fecUltimoAcceso;
    }

    public void setFecUltimoAcceso(LocalDate fecUltimoAcceso) {
        this.fecUltimoAcceso = fecUltimoAcceso;
    }

    public String getCreadoPor() {
        return creadoPor;
    }

    public void setCreadoPor(String creadoPor) {
        this.creadoPor = creadoPor;
    }

    public String getModificadoPor() {
        return modificadoPor;
    }

    public void setModificadoPor(String modificadoPor) {
        this.modificadoPor = modificadoPor;
    }

    public String getEliminadaPor() {
        return eliminadaPor;
    }

    public void setEliminadaPor(String eliminadaPor) {
        this.eliminadaPor = eliminadaPor;
    }

    public LocalTime getHoraCreacion() {
        return horaCreacion;
    }

    public void setHoraCreacion(LocalTime horaCreacion) {
        this.horaCreacion = horaCreacion;
    }

    public LocalTime getHoraModificacion() {
        return horaModificacion;
    }

    public void setHoraModificacion(LocalTime horaModificacion) {
        this.horaModificacion = horaModificacion;
    }

    public LocalTime getHoraEliminacion() {
        return horaEliminacion;
    }

    public void setHoraEliminacion(LocalTime horaEliminacion) {
        this.horaEliminacion = horaEliminacion;
    }

    public LocalTime getHoraUltimoAcceso() {
        return horaUltimoAcceso;
    }

    public void setHoraUltimoAcceso(LocalTime horaUltimoAcceso) {
        this.horaUltimoAcceso = horaUltimoAcceso;
    }

}
