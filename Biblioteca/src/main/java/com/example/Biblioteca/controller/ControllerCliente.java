package com.example.Biblioteca.controller;

import com.example.Biblioteca.database.DatabaseBiblioteca;
import com.example.Biblioteca.model.ModelCliente;

import java.util.List;

public class ControllerCliente {
        private static ControllerCliente instance;
        private final DatabaseBiblioteca database = new DatabaseBiblioteca();

        public ControllerCliente() {}

        public static ControllerCliente getInstance() {
            if (instance == null) {
                instance = new ControllerCliente();
            }
            return instance;
        }

        public void inserirCliente(ModelCliente cliente) {
            database.getClientes().put(cliente.getId(), cliente);
        }

        public List<ModelCliente> pegarTodosClientes() {
            return List.copyOf(database.getClientes().values());
        }

        public void atualizarCliente(Long id, ModelCliente novosDados) {
            database.atualizarCliente(id, novosDados);
        }

        public void deletarCliente(Long id) {
            database.getClientes().remove(id);
        }
    }


