
package com.tienda.Service;

import com.tienda.Domain.Categoria;
import java.util.List;


public interface CategoriaService {
    
    public List <Categoria> getCategorias(boolean activos); //Retorna toda la lista de Categorias
    
    public void save (Categoria categoria); //Esto lo que va a hacer es guardar un categoria nuevo, si este viene con un ID que ya existe, lo modifica
    
    public void delete (Categoria categoria); //Aca recibe un objeto entero, for now
    
    public Categoria getCategoria (Categoria categoria); //Va a retornar solamente un categoria en especifico
}
