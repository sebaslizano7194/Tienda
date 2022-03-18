/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.Service;

import com.tienda.Domain.Articulo;
import com.tienda.dao.ArticuloDao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Sebastián Lizano
 */
@Service
public class ArticuloServiceIMP implements ArticuloService {
    
    @Autowired //Crea una instancia sin tener que llamarla
    private ArticuloDao articuloDao;

    @Override
    @Transactional (readOnly = true)
    public List<Articulo> getArticulos(boolean activos) {
        var lista = (List<Articulo>) articuloDao.findAll();
        if (activos){
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;

    }

    @Override
    @Transactional //Si no se pone el readOnly, es que va a editar/escribir
    public void save(Articulo articulo) {
        articuloDao.save(articulo);
    }

    @Override
    public void delete(Articulo articulo) {
        articuloDao.delete(articulo);
    }

    @Override
    public Articulo getArticulo(Articulo articulo) {
        return articuloDao.findById(articulo.getIdArticulo()).orElse(null); //Va a buscar por ID, si lo encuentra great, si no, retorna un null. ojo!!
    }
    
}
