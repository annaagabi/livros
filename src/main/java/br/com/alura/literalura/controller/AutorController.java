package br.com.alura.literalura.controller;

import br.com.alura.literalura.dto.AutorDTO;
import br.com.alura.literalura.model.Autor;
import br.com.alura.literalura.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorService autorService;

    @GetMapping("/autor")
    public List<AutorDTO> buscarAutor() {
        return autorService.buscarAutor();

    }

}