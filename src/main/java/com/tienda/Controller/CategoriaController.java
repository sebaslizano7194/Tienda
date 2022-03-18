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
import com.tienda.Domain.Categoria;
import com.tienda.Service.CategoriaService;
import com.tienda.dao.CategoriaDao;
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
public class CategoriaController {

    @Autowired //Crea una instancia sin tener que llamarla
    private CategoriaService categoriaService;

    @GetMapping("/categoria/listado")
    public String page(Model model) {

        var categorias = categoriaService.getCategorias(false);
        model.addAttribute("categorias", categorias);
        
        return "/categoria/listado";
    }

    @GetMapping("/categoria/nuevo")
    public String nuevoCategoria(Categoria categoria) {
        return "/categoria/modifica"; //Creamos  una nueva vista pues
    }
    
    @PostMapping("/categoria/guardar")
    public String guardarCategoria(Categoria categoria){
        categoriaService.save(categoria);
        return "redirect:/categoria/listado"; //Aca estamos redireccionando a la accion default que esta arriba
    }
    
    @GetMapping("/categoria/modificar/{idCategoria}")
    public String modificarCategoria(Categoria categoria, Model model){
        var respuesta = categoriaService.getCategoria(categoria);
        model.addAttribute("categoria", respuesta);
        return "/categoria/modifica";
    }
    
    @GetMapping ("/categoria/eliminar/{idCategoria}")
    public String eliminarCategoria(Categoria categoria){
        categoriaService.delete(categoria);
        return "redirect:/categoria/listado";
    }

}
