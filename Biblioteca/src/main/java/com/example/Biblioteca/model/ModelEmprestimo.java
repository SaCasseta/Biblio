package com.example.Biblioteca.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Data
public class ModelEmprestimo {
        private Long id;
        private Date dataInicio;
        private Date dataFim;
        private List<ModelLivro> livros;
        private ModelCliente cliente;
}
