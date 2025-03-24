package com.example.Biblioteca.database;

import com.example.Biblioteca.model.ModelCliente;
import com.example.Biblioteca.model.ModelEmprestimo;
import com.example.Biblioteca.model.ModelLivro;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
@Getter
public class DatabaseBiblioteca {


        private final Map<Long, ModelCliente> clientes = new HashMap<>();
        private final Map<Long, ModelLivro> livros = new HashMap<>();
        private final Map<Long, ModelEmprestimo> emprestimos = new HashMap<>();
        private long emprestimoIdCounter = 1;

        public List<ModelEmprestimo> listarEmprestimos() {
            return new ArrayList<>(emprestimos.values());
        }

        public ModelEmprestimo registrarEmprestimo(ModelEmprestimo emprestimo) {
            emprestimo.setId(emprestimoIdCounter++);
            emprestimos.put(emprestimo.getId(), emprestimo);
            return emprestimo;
        }

        public boolean adicionarLivrosAoEmprestimo(Long emprestimoId, List<ModelLivro> novosLivros) {
            ModelEmprestimo emprestimo = emprestimos.get(emprestimoId);
            if (emprestimo != null) {
                emprestimo.getLivros().addAll(novosLivros);
                return true;
            }
            return false;
        }

        public boolean atualizarDataFinalEmprestimo(Long emprestimoId, Date DataFinal ) {
            ModelEmprestimo emprestimo = emprestimos.get(emprestimoId);
            if (emprestimo != null) {
                emprestimo.setDataFim(DataFinal);
                return true;
            }
            return false;
        }

        public boolean atualizarCliente(Long clienteId, ModelCliente novosDados) {
            if (clientes.containsKey(clienteId)) {
                clientes.put(clienteId, novosDados);
                return true;
            }
            return false;
        }

        public boolean excluirEmprestimo(Long emprestimoId) {
            return emprestimos.remove(emprestimoId) != null;
        }

        public List<ModelEmprestimo> consultarPorDataFinal(Date dataFim) {
            return emprestimos.values().stream()
                    .filter(e -> e.getDataFim().equals(dataFim))
                    .collect(Collectors.toList());
        }
    }


