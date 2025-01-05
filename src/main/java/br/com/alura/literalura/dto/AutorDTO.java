package br.com.alura.literalura.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collector;

public record AutorDTO (Long id,
                        String nome,
                        LocalDate dataNascimento,
                        LocalDate dataMorte){

}
