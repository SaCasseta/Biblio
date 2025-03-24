package com.example.Biblioteca.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ModelLivro {
    private Long id;
    private String nome;
    private String autor;
    private String genero;
}
