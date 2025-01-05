package br.com.alura.screenmatch.config;

//código configura o CORS (Cross-Origin Resource Sharing) em uma aplicação. Ele permite que o servidor aceite requisições vindas de um determinado domínio (neste caso, http://127.0.0.1:5500) e de certos métodos HTTP (como GET, POST, PUT, DELETE, etc.). Isso é útil para permitir que um frontend accesse a API sem problemas de origem cruzada
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfiguration implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("http://127.0.0.1:5500")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD", "TRACE", "CONNECT");
    }
}