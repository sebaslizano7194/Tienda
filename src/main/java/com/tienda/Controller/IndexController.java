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
import com.tienda.Service.ArticuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Sebastián Lizano
 */
@Controller
@Slf4j
public class IndexController {

    @Autowired //Crea una instancia sin tener que llamarla
    private ArticuloService articuloService;

    @GetMapping("/")
    public String page(Model model) {

        var articulos = articuloService.getArticulos(true);
        model.addAttribute("articulos", articulos);

        return "index";
    }
}
