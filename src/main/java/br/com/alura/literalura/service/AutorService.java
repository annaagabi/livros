package br.com.alura.literalura.service;

import br.com.alura.literalura.dto.AutorDTO;
import br.com.alura.literalura.dto.LivroDTO;
import br.com.alura.literalura.model.Autor;
import br.com.alura.literalura.model.Livros;
import br.com.alura.literalura.repository.AutorRepository;
import br.com.alura.literalura.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AutorService{
    @Autowired
    private AutorRepository autorRepositorio;
    @Autowired
    private final LivroRepository repositorio;

    @Autowired
    public AutorService(LivroRepository repositorio, AutorRepository autorRepositorio) {
        this.repositorio = repositorio;
        this.autorRepositorio = autorRepositorio;
    }


    public List<AutorDTO> buscarAutor(){
        return converteDados(autorRepositorio.findAll());


    }
    private List<AutorDTO> converteDados (List<Autor> autor) {
        return autor.stream()
                .map(s -> new AutorDTO(s.getId(), s.getNome(),s.getDataNascimento(), s.getDataMorte()))
                .collect(Collectors.toList());
    }
}


