package com.example.Biblioteca.view;

import com.example.Biblioteca.controller.ControllerCliente;
import com.example.Biblioteca.controller.ControllerLivro;
import com.example.Biblioteca.model.ModelCliente;
import com.example.Biblioteca.model.ModelLivro;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ViewCliente {

    ControllerCliente clienteController = new ControllerCliente();

    @GetMapping
    public List<ModelCliente> getAllClientes() {
        return clienteController.pegarTodosClientes();
    }

    @PostMapping
    public String postNovoCliente(@RequestBody ModelCliente cliente) {
        clienteController.inserirCliente(cliente);
        return "Cliente cadastrado com sucesso!";
    }
}
