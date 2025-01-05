package br.com.alura.literalura.controller;

import br.com.alura.literalura.dto.LivroDTO;
import br.com.alura.literalura.model.Livros;
import br.com.alura.literalura.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LivroController {
    @Autowired
    private LivroService livroService;

    @GetMapping("/livro")
    public List<LivroDTO> buscarLivros() {
        return livroService.buscarLivros();

    }

}
