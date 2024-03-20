package cl.amisoft.entrega4backend.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "usuarios", schema = "actividad")
@SequenceGenerator(name = "actividad.usuarios_id_seq", sequenceName = "actividad.usuarios_id_seq", allocationSize = 1)
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "actividad.usuarios_id_seq")
    private Long id;

    @Column(name = "GLS_USUARIO_N")
    private String nombre;

    @Column(name = "GLS_USUARIO_A")
    private String apellido;

    @Column(name = "RUT")
    private Long rut;

    @Column(name = "RUT_DV")
    private Character rutDv;

    @Column(name = "FEC_CREA", insertable = false, updatable = false)
    private LocalDate fechaCreacion;

    @Column(name = "FEC_MOD", insertable = false)
    private LocalDate fechaModificacion;

    @PrePersist
    protected void onCreate() {
        fechaCreacion = LocalDate.now();
    }

    @PreUpdate
    protected void onUpdate() {
        fechaModificacion = LocalDate.now();
    }

    public Usuario(){

    }

    public Usuario(Builder builder){
        this.id = builder.id;
        this.nombre = builder.nombre;
        this.apellido = builder.apellido;
        this.rut = builder.rut;
        this.rutDv = builder.rutDV;
        this.fechaCreacion = builder.fechaCreacion;
        this.fechaModificacion = builder.fechaModificacion;
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

    public Character getRutDv() {
        return rutDv;
    }

    public void setRutDv(Character rutDv) {
        this.rutDv = rutDv;
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

        public Usuario build(){
            return new Usuario(this);
        }
    }
}
