
package com.tienda.Service;

import com.tienda.Domain.Articulo;
import java.util.List;


public interface ArticuloService {
    
    public List <Articulo> getArticulos(boolean activos); //Retorna toda la lista de Articulos
    
    public void save (Articulo articulo); //Esto lo que va a hacer es guardar un articulo nuevo, si este viene con un ID que ya existe, lo modifica
    
    public void delete (Articulo articulo); //Aca recibe un objeto entero, for now
    
    public Articulo getArticulo (Articulo articulo); //Va a retornar solamente un articulo en especifico
}
