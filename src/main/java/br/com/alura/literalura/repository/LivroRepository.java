package br.com.alura.literalura.repository;

import br.com.alura.literalura.model.Idioma;
import br.com.alura.literalura.model.Livros;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LivroRepository extends JpaRepository<Livros, Long> {
    List<Livros> findByIdioma(Idioma idioma);

    List<Livros> findByTituloContainingIgnoreCase(String titulo);


}
