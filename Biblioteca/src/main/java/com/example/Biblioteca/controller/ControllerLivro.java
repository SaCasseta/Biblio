package com.example.Biblioteca.controller;

import com.example.Biblioteca.database.DatabaseBiblioteca;
import com.example.Biblioteca.model.ModelLivro;

import java.util.List;

public class ControllerLivro {
        private static ControllerLivro instance;
        private final DatabaseBiblioteca database = new DatabaseBiblioteca();

        public ControllerLivro() {}

        public static ControllerLivro getInstance() {
            if (instance == null) {
                instance = new ControllerLivro();
            }
            return instance;
        }

        public void inserirLivro(ModelLivro livro) {
            database.getLivros().put(livro.getId(), livro);
        }

        public List<ModelLivro> pegarTodosLivros() {
            return List.copyOf(database.getLivros().values());
        }

        public void atualizarLivro(Long id, ModelLivro livro) {
            database.getLivros().put(id, livro);
        }

        public void deletarLivro(Long id) {
            database.getLivros().remove(id);
        }
    }

