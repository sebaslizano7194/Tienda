
package com.tienda.Domain;

import java.io.Serial;
import java.io.Serializable;
import lombok.Data;
import lombok.Generated;
import javax.persistence.*;



@Data
@Entity
@Table(name="cliente")



public class Cliente implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    //Toda esa cosa para que el autoincremental funcione
    private long idcliente;
    private String nombre;
    private String apellidos;
    private String correo;
    private String telefono;

    public Cliente() {
    }

    public Cliente(String nombre, String apellidos, String correo, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;
        this.telefono = telefono;
    }
    
    
}
