/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tienda.Service;

import com.tienda.Domain.Cliente;
import com.tienda.Domain.Credito;
import com.tienda.dao.ClienteDao;
import com.tienda.dao.CreditoDao;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Sebastián Lizano
 */
@Service
public class ClienteServiceIMP implements ClienteService {

    @Autowired //Crea una instancia sin tener que llamarla
    private ClienteDao clienteDao;

    @Autowired
    private CreditoDao creditoDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> getClientes() {
        return (List<Cliente>) clienteDao.findAll(); //Parseamos la vara porque el findAll no retorna una lista

    }

    @Override
    @Transactional //Si no se pone el readOnly, es que va a editar/escribir
    public void save(Cliente cliente) {

        Credito credito = cliente.getCredito();
        credito = creditoDao.save(credito);

        cliente.setCredito(credito);
        clienteDao.save(cliente);
    }

    @Override
    public void delete(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    public Cliente getCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(null); //Va a buscar por ID, si lo encuentra great, si no, retorna un null. ojo!!
    }

    @Override
    public List<Cliente> findByCorreo(String correo) {
        return clienteDao.findByCorreo(correo);
    }

}
