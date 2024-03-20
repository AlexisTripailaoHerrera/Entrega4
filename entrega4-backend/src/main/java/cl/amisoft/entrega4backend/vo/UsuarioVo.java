package cl.amisoft.entrega4backend.vo;

import java.io.Serializable;
import java.time.LocalDate;

public class UsuarioVo implements Serializable {
    private static final long serialVersionUID = -8109351845131242564L;

    private Long id;
    private String nombre;
    private String apellido;
    private Long rut;
    private Character rutDV;
    private LocalDate fechaCreacion;
    private LocalDate fechaModificacion;

    public UsuarioVo(){

    }

    public UsuarioVo(Builder builder){
        this.id = builder.id;
        this.nombre = builder.nombre;
        this.apellido = builder.apellido;
        this.rut = builder.rut;
        this.rutDV = builder.rutDV;
        this.fechaCreacion = builder.fechaCreacion != null ? builder.fechaCreacion : LocalDate.now();
        this.fechaModificacion = builder.fechaModificacion != null ? builder.fechaModificacion : LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Character getRutDV() {
        return rutDV;
    }

    public void setRutDV(Character rutDV) {
        this.rutDV = rutDV;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public LocalDate getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(LocalDate fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public static class Builder {
        private Long id;
        private String nombre;
        private String apellido;
        private Long rut;
        private Character rutDV;
        private LocalDate fechaCreacion;
        private LocalDate fechaModificacion;

        public Builder id(Long id) {
            this.id = id;
            return this;
        }

        public Builder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public Builder apellido(String apellido) {
            this.apellido = apellido;
            return this;
        }

        public Builder rut(Long rut) {
            this.rut = rut;
            return this;
        }

        public Builder rutDV(Character rutDV) {
            this.rutDV = rutDV;
            return this;
        }

        public Builder fechaCreacion(LocalDate fechaCreacion) {
            this.fechaCreacion = fechaCreacion;
            return this;
        }

        public Builder fechaModificacion(LocalDate fechaModificacion) {
            this.fechaModificacion = fechaModificacion;
            return this;
        }

        public UsuarioVo build(){
            return new UsuarioVo(this);
        }
    }

}
