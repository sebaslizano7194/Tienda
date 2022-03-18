/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.tienda.Domain.Articulo;
import com.tienda.Service.ArticuloService;
import com.tienda.Service.CategoriaService;
import com.tienda.dao.ArticuloDao;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Sebastián Lizano
 */
@Controller
@Slf4j
public class ArticuloController {

    @Autowired //Crea una instancia sin tener que llamarla
    private ArticuloService articuloService;

    @Autowired //Crea una instancia sin tener que llamarla
    private CategoriaService categoriaService;

    @GetMapping("/articulo/listado")
    public String page(Model model) {

        var articulos = articuloService.getArticulos(false);
        model.addAttribute("articulos", articulos);

        return "/articulo/listado";
    }

    @GetMapping("/articulo/nuevo")
    public String nuevoArticulo(Articulo articulo, Model model) {
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);

        return "/articulo/modifica"; //Creamos  una nueva vista pues
    }

    @PostMapping("/articulo/guardar")
    public String guardarArticulo(Articulo articulo) {
        articuloService.save(articulo);
        return "redirect:/articulo/listado"; //Aca estamos redireccionando a la accion default que esta arriba
    }

    @GetMapping("/articulo/modifica/{idArticulo}")
    public String modificarArticulo(Articulo articulo, Model model) {
        var categorias = categoriaService.getCategorias(true);
        var respuesta = articuloService.getArticulo(articulo);
        
        model.addAttribute("articulo", respuesta);
        model.addAttribute("categorias", categorias);

        return "/articulo/modifica";
    }

    @GetMapping("/articulo/eliminar/{idArticulo}")
    public String eliminarArticulo(Articulo articulo) {
        articuloService.delete(articulo);
        return "redirect:/articulo/listado";
    }

}
