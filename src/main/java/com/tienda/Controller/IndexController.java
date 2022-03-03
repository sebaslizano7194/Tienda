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
import com.tienda.Service.ClienteService;
import com.tienda.dao.ClienteDao;
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
public class IndexController {

    @Autowired //Crea una instancia sin tener que llamarla
    private ClienteService clienteService;

    @RequestMapping("/")
    public String page(Model model) {

        String mensaje = "Mensaje desde el controlador";
        model.addAttribute("Mensaje", mensaje);

        Cliente cliente = new Cliente("Jonathan", "Brenes Blanco", "jbrenesbl@gmail.com", "8820-2655");
        model.addAttribute(cliente);
        Cliente cliente2 = new Cliente("PPP", "PPP", "PPP", "PPP");
        var clientes = Arrays.asList(cliente, cliente2);

        model.addAttribute("Clientes", clientes);

        var clientesDB = clienteService.getClientes();
        model.addAttribute("ClientesDB", clientesDB);
        return "index";
    }

    @GetMapping("/nuevoCliente")
    public String nuevoCliente(Cliente cliente) {
        return "modificarCliente"; //Creamos  una nueva vista pues
    }
    
    @PostMapping("/guardarCliente")
    public String guardarCliente(Cliente cliente){
        clienteService.save(cliente);
        return "redirect:/"; //Aca estamos redireccionando a la accion default que esta arriba
    }
    
    @GetMapping("/modificarCliente/{idcliente}")
    public String modificarCliente(Cliente cliente, Model model){
        var respuesta = clienteService.getCliente(cliente);
        model.addAttribute("cliente", respuesta);
        return "modificarCliente";
    }
    
    @GetMapping ("/eliminarCliente/{idcliente}")
    public String eliminarCliente(Cliente cliente){
        clienteService.delete(cliente);
        return "redirect:/";
    }

}
