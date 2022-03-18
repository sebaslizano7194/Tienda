
package com.tienda.dao;

import com.tienda.Domain.Articulo;
import org.springframework.data.repository.CrudRepository;


public interface ArticuloDao extends CrudRepository<Articulo, Long>{
    
}
