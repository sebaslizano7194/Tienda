
package com.tienda.Service;

import com.tienda.Domain.Cliente;
import java.util.List;


public interface ClienteService {
    
    public List <Cliente> getClientes(); //Retorna toda la lista de Clientes
    
    public void save (Cliente cliente); //Esto lo que va a hacer es guardar un cliente nuevo, si este viene con un ID que ya existe, lo modifica
    
    public void delete (Cliente cliente); //Aca recibe un objeto entero, for now
    
    public Cliente getCliente (Cliente cliente); //Va a retornar solamente un cliente en especifico
}
