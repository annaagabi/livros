package br.com.alura.literalura.model;

import br.com.alura.literalura.dto.LivroDTO;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {
    @JsonAlias("results") List<LivroDTO> results;

    // Getters y Setters
    public List<LivroDTO> getResults() {
        return results;
    }

    public void setResults(List<LivroDTO> results) {
        this.results = results;
    }
}
