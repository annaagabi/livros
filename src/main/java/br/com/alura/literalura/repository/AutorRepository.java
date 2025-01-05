package br.com.alura.literalura.repository;

import br.com.alura.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByNomeContainingIgnoreCase(String nome);


    List<Autor> findByDataMorteIsNullAndDataNascimentoIsNotNull();

//    @Query("SELECT a FROM Autor a WHERE a.data_nascimento <= :anioIngresado AND a.data_morte >= :anioIngresado")
//List<Autor> encontrarAutoresPorAno(@Param("anoIngresado") Integer anioIngresado);

    @Query("SELECT a FROM Autor a WHERE a.nome LIKE %:nome%")
    List<Autor> buscaAutores(@Param("nome") String nome);
}
