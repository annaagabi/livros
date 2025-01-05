package br.com.alura.literalura.service;

import br.com.alura.literalura.dto.LivroDTO;
import br.com.alura.literalura.model.Livros;
import br.com.alura.literalura.repository.AutorRepository;
import br.com.alura.literalura.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LivroService {
    @Autowired
    private AutorRepository autorRepositorio;
    @Autowired
    private final LivroRepository repositorio;


    @Autowired
    public LivroService(LivroRepository repositorio, AutorRepository autorRepositorio) {
        this.repositorio = repositorio;
        this.autorRepositorio = autorRepositorio;
    }

    public List<LivroDTO> buscarLivros(){
        return converteDados(repositorio.findAll());


    }
    private List<LivroDTO> converteDados (List<Livros> series) {
        return series.stream()
                .map(s -> new LivroDTO(s.getTitulo(),s.getIdioma(), s.getNumeroDownloads()))
                .collect(Collectors.toList());
    }


}
