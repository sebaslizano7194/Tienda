
package com.tienda.Domain;

import java.io.Serial;
import java.io.Serializable;
import lombok.Data;
import lombok.Generated;
import javax.persistence.*;



@Data
@Entity
@Table(name="credito")



public class Credito implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_credito")
    //Toda esa cosa para que el autoincremental funcione
    private long idCredito;
    private double limite;
    
    
    public Credito() {
    }

    public Credito(double limite) {
        this.limite = limite;
    } 
}
