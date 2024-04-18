package mx.utng.MAAI.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

@Entity
public class Inventario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Column(length = 90)
    private String name;

    @NotEmpty
    @Column(length = 200)
    private String descripcion;

    @Min(0)
    @Max(50000)
    private int stock;
   
    @Min(0)
    @Max(50000)
    private double precio;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public void setprecio(double precio) {
        this.precio = precio;
    }

    public double precio() {
        return precio;
    }
    public void stock(int stock) {
        this.stock = stock;
    }

    public int stock() {
        return stock;
    }
}
