
package com.tienda.dao;

import com.tienda.Domain.Cliente;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface ClienteDao extends CrudRepository<Cliente, Long>{
    public List<Cliente> findByCorreo(String correo);
}
