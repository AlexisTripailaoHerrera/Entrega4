package cl.amisoft.entrega4backend.dto;

public class UsuarioActualizarRequest {
    private Long id;
    private String nuevoNombre;
    private String nuevoApellido;
    private Long nuevoRut;
    private Character nuevoDv;

    public UsuarioActualizarRequest(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNuevoNombre() {
        return nuevoNombre;
    }

    public void setNuevoNombre(String nuevoNombre) {
        this.nuevoNombre = nuevoNombre;
    }

    public String getNuevoApellido() {
        return nuevoApellido;
    }

    public void setNuevoApellido(String nuevoApellido) {
        this.nuevoApellido = nuevoApellido;
    }

    public Long getNuevoRut() {
        return nuevoRut;
    }

    public void setNuevoRut(Long nuevoRut) {
        this.nuevoRut = nuevoRut;
    }

    public Character getNuevoDv() {
        return nuevoDv;
    }

    public void setNuevoDv(Character nuevoDv) {
        this.nuevoDv = nuevoDv;
    }
}
