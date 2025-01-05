package br.com.alura.literalura.model;

import jakarta.persistence.*;

@Entity
@Table(name="livros")
public class Livros {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    @Column(unique = true)
    private String titulo;
    @ManyToOne
    private Autor autor;
    @Enumerated(EnumType.STRING)
    private Idioma idioma;
    private Integer numeroDownloads;

    public Livros(){

    }
    public Livros (DadosLivros dadosLivros){
        this.titulo = dadosLivros.titulo();
        this.idioma = Idioma.fromString(dadosLivros.idioma().trim());
        this.numeroDownloads = dadosLivros.numeroDowloads();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public Integer getNumeroDownloads() {
        return numeroDownloads;
    }

    public void setNumeroDownloads(Integer numeroDownloads) {
        this.numeroDownloads = numeroDownloads;
    }

    @Override
    public String toString() {
        return
                " Titulo do Livro: '" + titulo +
                ", Autor: " + autor +
                ", Idioma: " + idioma +
                ", Número de Downloads: " + numeroDownloads;
    }
}
