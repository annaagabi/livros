package br.com.alura.literalura.service;

import br.com.alura.literalura.dto.LivroDTO;
import br.com.alura.literalura.model.ApiResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConverteDados implements IConverteDados {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public <T> T obterDados(String json, Class<T> clase) {
        try {

            ApiResponse apiResponse = mapper.readValue(json, ApiResponse.class);
            if (apiResponse != null && apiResponse.getResults() != null && !apiResponse.getResults().isEmpty()) {

                LivroDTO livroDTO = apiResponse.getResults().get(0);
                System.out.println("Primeiro livro: " + livroDTO);
                return (T) livroDTO;
            } else {
                throw new RuntimeException("Não foi encontrado nenhum livro.");
            }
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error ao desserializar JSON: " + e.getMessage(), e);
        }
    }
}
