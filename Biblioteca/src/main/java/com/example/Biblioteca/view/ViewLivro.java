package com.example.Biblioteca.view;

import com.example.Biblioteca.controller.ControllerLivro;
import com.example.Biblioteca.model.ModelLivro;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Livro")
public class ViewLivro {
    ControllerLivro livroController = new ControllerLivro();

    @GetMapping
    public List<ModelLivro> getAllLivros() {
        return livroController.pegarTodosLivros();
    }

    @PostMapping
    public String postNovoLivro(@RequestBody ModelLivro livro) {
        livroController.inserirLivro(livro);
        return "Livro cadastrado com sucesso!";
    }
   
}
