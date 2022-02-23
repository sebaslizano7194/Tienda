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
import com.tienda.Domain.Cliente;
import com.tienda.dao.ClienteDao;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Sebastián Lizano
 */
@Controller
@Slf4j
public class IndexController {
    
    @Autowired //Crea una instancia sin tener que llamarla
    private ClienteDao clienteDao;
    
    @RequestMapping("/")
    public String page(Model model) {
        
        
        String mensaje = "Mensaje desde el controlador";
        model.addAttribute("Mensaje", mensaje);
        
        Cliente cliente = new Cliente("Jonathan", "Brenes Blanco", "jbrenesbl@gmail.com", "8820-2655");
        model.addAttribute(cliente);
        Cliente cliente2 = new Cliente("PPP", "PPP", "PPP", "PPP");
        var clientes = Arrays.asList(cliente, cliente2);
        
        model.addAttribute("Clientes", clientes);
        
        var clientesDB = clienteDao.findAll();
        model.addAttribute("ClientesDB", clientesDB);
        return "index";
    }
    
}
