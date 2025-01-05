package br.com.alura.literalura.dto;

import br.com.alura.literalura.model.Idioma;
import com.fasterxml.jackson.annotation.JsonAlias;

import java.util.List;

public record LivroDTO (String titulo,
                        Idioma idioma,
                        Integer numeroDowloads){
}
