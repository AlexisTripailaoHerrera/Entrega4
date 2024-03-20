package cl.amisoft.entrega4backend.vo;

import java.io.Serializable;
import java.time.LocalDate;

public class UsuariosEliminadosVo implements Serializable {
    private static final long serialVersionUID = 4794192614088964788L;

    private Long id;
    private String nombreEliminado;
    private String apellidoEliminado;
    private Long rutEliminado;
    private Character rutDvEliminado;
    private LocalDate fechaEliminacion;

    public UsuariosEliminadosVo(){

    }

    public UsuariosEliminadosVo(Builder builder){
        this.id = builder.id;
        this.nombreEliminado = builder.nombreEliminado;
        this.apellidoEliminado = builder.apellidoEliminado;
        this.rutEliminado = builder.rutEliminado;
        this.rutDvEliminado = builder.rutDvEliminado;
        this.fechaEliminacion = builder.fechaEliminacion != null ? builder.fechaEliminacion : LocalDate.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreEliminado() {
        return nombreEliminado;
    }

    public void setNombreEliminado(String nombreEliminado) {
        this.nombreEliminado = nombreEliminado;
    }

    public String getApellidoEliminado() {
        return apellidoEliminado;
    }

    public void setApellidoEliminado(String apellidoEliminado) {
        this.apellidoEliminado = apellidoEliminado;
    }

    public Long getRutEliminado() {
        return rutEliminado;
    }

    public void setRutEliminado(Long rutEliminado) {
        this.rutEliminado = rutEliminado;
    }

    public Character getRutDvEliminado() {
        return rutDvEliminado;
    }

    public void setRutDvEliminado(Character rutDvEliminado) {
        this.rutDvEliminado = rutDvEliminado;
    }

    public LocalDate getFechaEliminacion() {
        return fechaEliminacion;
    }

    public void setFechaEliminacion(LocalDate fechaEliminacion) {
        this.fechaEliminacion = fechaEliminacion;
    }

    public static class Builder {
        private Long id;
        private String nombreEliminado;
        private String apellidoEliminado;
        private Long rutEliminado;
        private Character rutDvEliminado;
        private LocalDate fechaEliminacion;

        public Builder ido(Long id){
            this.id = id;
            return this;
        }

        public Builder nombreEliminado(String nombreEliminado){
            this.nombreEliminado = nombreEliminado;
            return this;
        }

        public Builder apellidoEliminado(String apellidoEliminado){
            this.apellidoEliminado = apellidoEliminado;
            return this;
        }

        public Builder rutEliminado(Long rutEliminado){
            this.rutEliminado = rutEliminado;
            return this;
        }

        public Builder rutDvEliminado(Character rutDvEliminado){
            this.rutDvEliminado = rutDvEliminado;
            return this;
        }

        public Builder fechaEliminacion(LocalDate fechaEliminacion){
            this.fechaEliminacion = fechaEliminacion;
            return this;
        }

        public UsuariosEliminadosVo build(){
            return new UsuariosEliminadosVo(this);
        }

    }


}
