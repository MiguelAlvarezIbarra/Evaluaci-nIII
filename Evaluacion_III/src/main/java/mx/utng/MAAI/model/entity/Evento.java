package mx.utng.MAAI.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Evento {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty
    @Column(length = 30)
    private String nombre;

    @NotEmpty
    @Column(length = 30)
    private String fechaI;

    @NotEmpty
    @Column(length = 30)
    private String fechaF;

    @NotEmpty
    @Column(length = 50)
    private String ubicacion;

    
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
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public String getFechaF() {
        return fechaF;
    }
    public void setFechaF(String fechaF) {
        this.fechaF = fechaF;
    }
    public String getFechaI() {
        return fechaI;
    }
    public void setFechaI(String fechaI) {
        this.fechaI = fechaI;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", nombre=" + nombre + ", fechaI="+ fechaI+   
                 ", fechaF=" + fechaF + "]";
    }
}
