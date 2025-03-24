package com.example.Biblioteca.controller;

import com.example.Biblioteca.database.DatabaseBiblioteca;
import com.example.Biblioteca.model.ModelEmprestimo;
import java.util.List;
public class ControllerEmprestimo {

        private static ControllerEmprestimo instance;
        private final DatabaseBiblioteca database = new DatabaseBiblioteca();

        private ControllerEmprestimo() {}

        public static ControllerEmprestimo getInstance() {
            if (instance == null) {
                instance = new ControllerEmprestimo();
            }
            return instance;
        }

        public void inserirEmprestimo(ModelEmprestimo emprestimo) {
            database.registrarEmprestimo(emprestimo);
        }

        public List<ModelEmprestimo> pegarTodosEmprestimos() {
            return database.listarEmprestimos();
        }

        public void atualizarDataFinal(Long id, java.util.Date novaData) {
            database.atualizarDataFinalEmprestimo(id, novaData);
        }

        public void deletarEmprestimo(Long id) {
            database.excluirEmprestimo(id);
        }
}

