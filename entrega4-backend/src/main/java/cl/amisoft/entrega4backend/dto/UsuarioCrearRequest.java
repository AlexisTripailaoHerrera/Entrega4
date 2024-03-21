package cl.amisoft.entrega4backend.dto;

import java.time.LocalDate;

public class UsuarioCrearRequest {
    private String nombre;
    private String apellido;
    private Long rut;
    private Character rutDv;

    public UsuarioCrearRequest(){

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long getRut() {
        return rut;
    }

    public void setRut(Long rut) {
        this.rut = rut;
    }

    public Character getRutDv() {
        return rutDv;
    }

    public void setRutDv(Character rutDv) {
        this.rutDv = rutDv;
    }
}
