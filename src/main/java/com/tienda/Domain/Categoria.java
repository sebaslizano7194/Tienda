
package com.tienda.Domain;

import java.io.Serial;
import java.io.Serializable;
import lombok.Data;
import lombok.Generated;
import javax.persistence.*;



@Data
@Entity
@Table(name="categoria")



public class Categoria implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_categoria")
    
    //Toda esa cosa para que el autoincremental funcione
    private long idCategoria;
    private String descripcion;
    private boolean activo;

    public Categoria() {
    }

    public Categoria(String descripcion, boolean activo) {
        this.descripcion = descripcion;
        this.activo = activo;
    }
    
    

    



    
    
}
