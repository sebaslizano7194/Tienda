/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.Service;

import com.tienda.Domain.Categoria;
import com.tienda.dao.CategoriaDao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Sebastián Lizano
 */
@Service
public class CategoriaServiceIMP implements CategoriaService {
    
    @Autowired //Crea una instancia sin tener que llamarla
    private CategoriaDao categoriaDao;

    @Override
    @Transactional (readOnly = true)
    public List<Categoria> getCategorias(boolean activos) {
        var lista = (List<Categoria>) categoriaDao.findAll();
        if (activos){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;

    }

    @Override
    @Transactional //Si no se pone el readOnly, es que va a editar/escribir
    public void save(Categoria categoria) {
        categoriaDao.save(categoria);
    }

    @Override
    public void delete(Categoria categoria) {
        categoriaDao.delete(categoria);
    }

    @Override
    public Categoria getCategoria(Categoria categoria) {
        return categoriaDao.findById(categoria.getIdCategoria()).orElse(null); //Va a buscar por ID, si lo encuentra great, si no, retorna un null. ojo!!
    }
    
}
