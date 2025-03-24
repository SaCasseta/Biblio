package com.example.Biblioteca.model;



import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class ModelCliente {
        private Long id;
        private String nome;
        private String cpf;
        private String telefone;
        private String email;
}
